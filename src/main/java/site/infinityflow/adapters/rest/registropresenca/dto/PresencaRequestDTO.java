package site.infinityflow.adapters.rest.registropresenca.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class PresencaRequestDTO {
    @JsonProperty("id_aula")
    private String idAula;
    @JsonProperty("lista_presencas")
    private final List<SituacaoAlunoDTO> listaPresenca = new ArrayList<>();

    @Getter
    public static class SituacaoAlunoDTO {
        @JsonProperty("id_aluno")
        protected String idAluno;
        protected String situacao;
    }
}