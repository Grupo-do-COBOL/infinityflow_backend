package site.infinityflow.usecases.clients;

import site.infinityflow.adapters.rest.tabelausuarios.dto.response.TabelaUsuariosResponseDTO;

import java.util.Optional;

public interface TabelaUsuariosClient {

    Optional<TabelaUsuariosResponseDTO> buscarUsuario(Integer id);

}
