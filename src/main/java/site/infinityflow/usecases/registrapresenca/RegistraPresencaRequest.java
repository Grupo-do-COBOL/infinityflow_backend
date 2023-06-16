package site.infinityflow.usecases.registrapresenca;

import lombok.Builder;
import lombok.Getter;
import site.infinityflow.entities.sistema.enums.Situacao;

import java.util.List;

@Builder
@Getter
public class RegistraPresencaRequest {
    private Integer idAula;
    private List<PresencasRequest> presencasRequests;

    @Builder
    @Getter
    public static class PresencasRequest {
        private Integer idAluno;
        private Situacao situacao;
    }
}
