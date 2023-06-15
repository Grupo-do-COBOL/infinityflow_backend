package site.infinityflow.usecases.gerarelatorio;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PresencaAluno {
    @JsonProperty("id_aluno")
    private Integer idAluno;
    @JsonProperty("nome_aluno")
    private String nomeAluno;
    private String disciplina;
    private String turma;
    private String periodo;
    private Integer bimestre;
    private Long presencas;
    private Long faltas;
}