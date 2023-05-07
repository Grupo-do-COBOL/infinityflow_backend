package site.infinityflow.adapters.rest.registropresenca.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AulaResponseDTO {
    @JsonProperty("id_aula")
    Integer idAula;
    @JsonProperty("id_dado_letivo")
    Integer idDadoLetivo;
    String materia;
    @JsonProperty("ano_letivo")
    Integer anoLetivo;
    String turma;
    String periodo;
    Integer bimestre;
}
