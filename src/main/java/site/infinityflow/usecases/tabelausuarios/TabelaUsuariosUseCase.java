package site.infinityflow.usecases.tabelausuarios;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.infinityflow.adapters.mysql.repository.TabelaUsuariosRepository;
import site.infinityflow.adapters.rest.tabelausuarios.dto.response.TabelaUsuariosResponseDTO;
import site.infinityflow.adapters.rest.tabelausuarios.mappers.response.TabelaUsuariosResponseMapper;
import site.infinityflow.entities.TabelaUsuariosEntity;
import site.infinityflow.usecases.clients.TabelaUsuariosClient;

import java.util.Optional;

@Service
public class TabelaUsuariosUseCase implements TabelaUsuariosClient {

    @Autowired
    private TabelaUsuariosRepository tabelaUsuariosRepository;

    @Autowired
    private TabelaUsuariosResponseMapper tabelaUsuariosResponseMapper;

    public Optional<TabelaUsuariosResponseDTO> buscarUsuario(Integer id) {
        Optional<TabelaUsuariosEntity> usuarios = tabelaUsuariosRepository.findById(id);

        if (usuarios.isPresent()) {
            return Optional.ofNullable(tabelaUsuariosResponseMapper.mapEntityToDto(usuarios.get()));
        } else {
            throw new RuntimeException("Usuario não encontrado");
        }
    }
}
