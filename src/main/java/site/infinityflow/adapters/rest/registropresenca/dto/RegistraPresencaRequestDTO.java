package site.infinityflow.adapters.rest.registropresenca.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class RegistraPresencaRequestDTO {
    String situacao;
    @JsonProperty("id_aluno")
    String idAluno;
    @JsonProperty("id_aula")
    String idAula;
}