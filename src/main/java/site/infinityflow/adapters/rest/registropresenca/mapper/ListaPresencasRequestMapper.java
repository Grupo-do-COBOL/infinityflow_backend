package site.infinityflow.adapters.rest.registropresenca.mapper;

import org.springframework.stereotype.Component;
import site.infinityflow.adapters.rest.registropresenca.dto.PresencaRequestDTO;
import site.infinityflow.entities.sistema.enums.Situacao;
import site.infinityflow.usecases.registrapresenca.RegistraPresencaRequest;

import java.util.ArrayList;
import java.util.List;

@Component
public class ListaPresencasRequestMapper {
    public RegistraPresencaRequest mapDtoToRequest(PresencaRequestDTO dto) {
        List<RegistraPresencaRequest.PresencasRequest> presencasRequests = new ArrayList<>();
        dto.getListaPresenca().forEach(p -> presencasRequests.add(
                        RegistraPresencaRequest.PresencasRequest.builder()
                                .idAluno(Integer.parseInt(p.getIdAluno()))
                                .situacao(Situacao.converteParaEnum(p.getSituacao().charAt(0)))
                                .build()
                )
        );
        return RegistraPresencaRequest.builder()
                .idAula(Integer.parseInt(dto.getIdAula()))
                .presencasRequests(presencasRequests)
                .build();
    }
}
