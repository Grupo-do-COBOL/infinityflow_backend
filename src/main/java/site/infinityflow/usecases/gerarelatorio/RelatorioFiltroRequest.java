package site.infinityflow.usecases.gerarelatorio;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class RelatorioFiltroRequest {
    private String data;
    private String anoLetivo;
    private String turma;
    private String professor;
    private String disciplina;
    private String aluno;
}
