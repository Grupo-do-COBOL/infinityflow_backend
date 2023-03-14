package site.infinityflow.usecases.tabelausuarios;


import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import site.infinityflow.adapters.mysql.repository.TabelaUsuariosRepository;
import site.infinityflow.adapters.rest.tabelausuarios.dto.request.AuthenticationRequestDTO;
import site.infinityflow.adapters.rest.tabelausuarios.dto.request.TabelaUsuariosRequestDTO;
import site.infinityflow.adapters.rest.tabelausuarios.dto.response.AuthenticationResponseDTO;
import site.infinityflow.adapters.rest.tabelausuarios.mappers.response.TabelaUsuariosResponseMapper;
import site.infinityflow.entities.Funcao;
import site.infinityflow.entities.TabelaUsuariosEntity;
import site.infinityflow.usecases.jwt.JwtUseCase;

@Service
@RequiredArgsConstructor
public class TabelaUsuariosUseCase {

    private final TabelaUsuariosRepository tabelaUsuariosRepository;

    private final TabelaUsuariosResponseMapper tabelaUsuariosResponseMapper;

    private final PasswordEncoder passwordEncoder;

    private final JwtUseCase jwtUseCase;

    private final AuthenticationManager authenticationManager;

//    public Optional<TabelaUsuariosResponseDTO> buscarUsuario(Integer id) {
//        Optional<TabelaUsuariosEntity> usuarios = tabelaUsuariosRepository.findById(id);
//
//        if (usuarios.isPresent()) {
//            return Optional.ofNullable(tabelaUsuariosResponseMapper.mapEntityToDto(usuarios.get()));
//        } else {
//            throw new RuntimeException("Usuario não encontrado");
//        }
//    }


    public AuthenticationResponseDTO registrar(TabelaUsuariosRequestDTO request) {

        TabelaUsuariosEntity usuario = tabelaUsuariosResponseMapper.mapDtoToEntity(TabelaUsuariosRequestDTO.builder()
                .nome(request.getNome())
                .email(request.getEmail())
                .senha(passwordEncoder.encode(request.getSenha()))
                .funcao(Funcao.PROFESSOR)
                .build());
        tabelaUsuariosRepository.save(usuario);

        var jwtToken = jwtUseCase.generateToken(usuario);

        return AuthenticationResponseDTO.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponseDTO autenticar(AuthenticationRequestDTO request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getSenha()));

        var usuario = tabelaUsuariosRepository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtUseCase.generateToken(usuario);

        return AuthenticationResponseDTO.builder()
                .token(jwtToken)
                .build();
    }
}
