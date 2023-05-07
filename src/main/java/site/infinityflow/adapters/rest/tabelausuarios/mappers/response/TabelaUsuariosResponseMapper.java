package site.infinityflow.adapters.rest.tabelausuarios.mappers.response;

import org.springframework.stereotype.Component;
import site.infinityflow.adapters.rest.tabelausuarios.dto.request.TabelaUsuariosRequestDTO;
import site.infinityflow.adapters.rest.tabelausuarios.dto.response.TabelaUsuariosResponseDTO;
import site.infinityflow.entities.security.UsuariosEntity;


@Component
public class TabelaUsuariosResponseMapper {

    public TabelaUsuariosResponseDTO mapEntityToDto(UsuariosEntity usuariosEntity) {
        return TabelaUsuariosResponseDTO.builder()
                .email(usuariosEntity.getEmail())
                .nome(usuariosEntity.getNome())
                .funcao(usuariosEntity.getFuncao())
                .professorId(usuariosEntity.getProfessorId())
                .build();
    }

    public UsuariosEntity mapDtoToEntity(TabelaUsuariosRequestDTO tabelaUsuariosRequestDTO) {
        UsuariosEntity usuariosEntity = new UsuariosEntity();
        usuariosEntity.setNome(tabelaUsuariosRequestDTO.getNome());
        usuariosEntity.setSenha(tabelaUsuariosRequestDTO.getSenha());
        usuariosEntity.setFuncao(tabelaUsuariosRequestDTO.getFuncao());
        usuariosEntity.setEmail(tabelaUsuariosRequestDTO.getEmail());
       return usuariosEntity;
    }
}
