package site.infinityflow.adapters.rest.registropresenca.mapper;

import org.springframework.stereotype.Component;
import site.infinityflow.adapters.rest.registropresenca.dto.RegistraPresencaRequestDTO;
import site.infinityflow.entities.sistema.enums.Situacao;
import site.infinityflow.usecases.registrapresenca.RegistraPresencaRequest;

@Component
public class RegistraPresencaMapper {
    public RegistraPresencaRequest mapDtoToRequest(RegistraPresencaRequestDTO dto) {
        return RegistraPresencaRequest.builder()
                .idAluno(Integer.parseInt(dto.getIdAluno()))
                .idAula(Integer.parseInt(dto.getIdAula()))
                .situacao(Situacao.converteParaEnum(dto.getSituacao().charAt(0)))
                .build();
    }
}
