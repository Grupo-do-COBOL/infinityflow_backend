package site.infinityflow.usecases.gerarelatorio;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PresencaAluno {
    @JsonProperty("id_aluno")
    Integer idAluno;
    @JsonProperty("nome_aluno")
    String nomeAluno;
    String materia;
    Long presencas;
    Long faltas;
}
