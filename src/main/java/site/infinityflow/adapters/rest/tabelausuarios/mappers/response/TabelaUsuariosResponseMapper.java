package site.infinityflow.adapters.rest.tabelausuarios.mappers.response;

import org.springframework.stereotype.Component;
import site.infinityflow.adapters.rest.tabelausuarios.dto.request.TabelaUsuariosRequestDTO;
import site.infinityflow.adapters.rest.tabelausuarios.dto.response.TabelaUsuariosResponseDTO;
import site.infinityflow.entities.security.TabelaUsuariosEntity;


@Component
public class TabelaUsuariosResponseMapper {

    public TabelaUsuariosResponseDTO mapEntityToDto(TabelaUsuariosEntity tabelaUsuariosEntity) {
        return TabelaUsuariosResponseDTO.builder()
                .email(tabelaUsuariosEntity.getEmail())
                .nome(tabelaUsuariosEntity.getNome())
                .funcao(tabelaUsuariosEntity.getFuncao())
                .build();
    }

    public TabelaUsuariosEntity mapDtoToEntity(TabelaUsuariosRequestDTO tabelaUsuariosRequestDTO) {
        TabelaUsuariosEntity tabelaUsuariosEntity = new TabelaUsuariosEntity();
        tabelaUsuariosEntity.setNome(tabelaUsuariosRequestDTO.getNome());
        tabelaUsuariosEntity.setSenha(tabelaUsuariosRequestDTO.getSenha());
        tabelaUsuariosEntity.setFuncao(tabelaUsuariosRequestDTO.getFuncao());
        tabelaUsuariosEntity.setEmail(tabelaUsuariosRequestDTO.getEmail());
       return tabelaUsuariosEntity;
    }
}
