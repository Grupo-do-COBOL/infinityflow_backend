package site.infinityflow.usecases.registrapresenca;

import lombok.Builder;
import lombok.Getter;
import site.infinityflow.entities.sistema.enums.Situacao;

@Builder
@Getter
public class RegistraPresencaRequest {
    Integer idAluno;
    Integer idAula;
    Situacao situacao;
}
