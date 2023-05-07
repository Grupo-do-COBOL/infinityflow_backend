package site.infinityflow.adapters.rest.registropresenca.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AulaResponseDTO {
    @JsonProperty("id_aula")
    private Integer idAula;
    @JsonProperty("id_dado_letivo")
    private Integer idDadoLetivo;
    private String materia;
    @JsonProperty("ano_letivo")
    private Integer anoLetivo;
    private String turma;
    private String periodo;
    private Integer bimestre;
}
