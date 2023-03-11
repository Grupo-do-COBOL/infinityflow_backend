package site.infinityflow.adapters.rest.tabelausuarios.mappers.response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import site.infinityflow.adapters.rest.tabelausuarios.dto.response.TabelaUsuariosResponseDTO;
import site.infinityflow.entities.TabelaUsuariosEntity;


@Component
public class TabelaUsuariosResponseMapper {

    public TabelaUsuariosResponseDTO mapEntityToDto(TabelaUsuariosEntity tabelaUsuariosEntity) {
        return TabelaUsuariosResponseDTO.builder()
                .id(tabelaUsuariosEntity.getId())
                .email(tabelaUsuariosEntity.getEmail())
                .nome(tabelaUsuariosEntity.getNome())
                .funcao(tabelaUsuariosEntity.getFuncao())
                .build();
    }

}
