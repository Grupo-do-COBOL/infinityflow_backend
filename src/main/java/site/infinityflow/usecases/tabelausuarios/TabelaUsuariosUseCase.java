package site.infinityflow.usecases.tabelausuarios;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.infinityflow.adapters.mysql.repository.TabelaUsuariosRepository;
import site.infinityflow.adapters.rest.tabelausuarios.dto.response.TabelaUsuariosResponseDTO;
import site.infinityflow.adapters.rest.tabelausuarios.mappers.response.TabelaUsuariosResponseMapper;
import site.infinityflow.entities.TabelaUsuariosEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TabelaUsuariosUseCase {

    private final TabelaUsuariosRepository tabelaUsuariosRepository;

    private final TabelaUsuariosResponseMapper tabelaUsuariosResponseMapper;

    public Optional<TabelaUsuariosResponseDTO> buscarUsuario(Integer id) {
        Optional<TabelaUsuariosEntity> usuarios = tabelaUsuariosRepository.findById(id);

        if (usuarios.isPresent()) {
            return Optional.ofNullable(tabelaUsuariosResponseMapper.mapEntityToDto(usuarios.get()));
        } else {
            throw new RuntimeException("Usuario não encontrado");
        }
    }

    public Optional<TabelaUsuariosResponseDTO> buscarPorEmail(String email) {
        Optional<TabelaUsuariosEntity> emailUsuario = tabelaUsuariosRepository.findByEmail(email);

        if (emailUsuario.isPresent()) {
            return Optional.ofNullable(tabelaUsuariosResponseMapper.mapEntityToDto(emailUsuario.get()));
        } else {
            throw new RuntimeException("Não existe nenhum usuario cadastrado com esse email");
        }
    }

    public Optional<TabelaUsuariosResponseDTO> buscarPorNome(String nome) {
        Optional<TabelaUsuariosEntity> nomeUsuario = tabelaUsuariosRepository.findByNome(nome);

        if (nomeUsuario.isPresent()) {
            return Optional.ofNullable(tabelaUsuariosResponseMapper.mapEntityToDto(nomeUsuario.get()));
        } else {
            throw new RuntimeException("Não existe nenhum usuario cadastrado com esse nome");
        }
    }

    public List<TabelaUsuariosResponseDTO> buscarTodosUsuarios() {
        List<TabelaUsuariosEntity> usuarios = tabelaUsuariosRepository.findAll();

        if (usuarios.isEmpty()) {
            throw new RuntimeException("Não há usuários cadastrados");
        }

        List<TabelaUsuariosResponseDTO> usuariosDTO = new ArrayList<>();
        for (TabelaUsuariosEntity usuario : usuarios) {
            usuariosDTO.add(tabelaUsuariosResponseMapper.mapEntityToDto(usuario));
        }

        return usuariosDTO;
    }

}
