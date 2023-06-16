package site.infinityflow.usecases.tabelausuarios;


import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import site.infinityflow.adapters.mysql.repository.UsuariosRepository;
import site.infinityflow.adapters.rest.tabelausuarios.dto.request.AuthenticationRequestDTO;
import site.infinityflow.adapters.rest.tabelausuarios.dto.request.TabelaUsuariosRequestDTO;
import site.infinityflow.adapters.rest.tabelausuarios.dto.response.AuthenticationResponseDTO;
import site.infinityflow.adapters.rest.tabelausuarios.mappers.response.TabelaUsuariosResponseMapper;
import site.infinityflow.entities.security.Funcao;
import site.infinityflow.entities.security.UsuariosEntity;
import site.infinityflow.usecases.jwt.JwtUseCase;
import site.infinityflow.usecases.smtp.SmtpUseCase;

@Service
@RequiredArgsConstructor
public class UsuariosLoginUseCase {

    private final UsuariosRepository usuariosRepository;

    private final TabelaUsuariosResponseMapper tabelaUsuariosResponseMapper;

    private final PasswordEncoder passwordEncoder;

    private final JwtUseCase jwtUseCase;

    private final AuthenticationManager authenticationManager;

    private final SmtpUseCase enviarEmail;


    public AuthenticationResponseDTO registrar(TabelaUsuariosRequestDTO request) throws MessagingException {

        if (usuariosRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Esse email já foi cadastrado!");
        }
        UsuariosEntity usuario = tabelaUsuariosResponseMapper.mapDtoToEntity(TabelaUsuariosRequestDTO.builder()
                .nome(request.getNome())
                .email(request.getEmail())
                .senha(passwordEncoder.encode(request.getSenha()))
                .funcao(Funcao.PROFESSOR)
                .build());

        usuariosRepository.save(usuario);
        enviarEmail.sendConfirmacaoRegistro(request);

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

        var usuario = usuariosRepository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtUseCase.generateToken(usuario);

        return AuthenticationResponseDTO.builder()
                .token(jwtToken)
                .build();
    }
}
