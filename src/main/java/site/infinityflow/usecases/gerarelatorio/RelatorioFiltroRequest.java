package site.infinityflow.usecases.gerarelatorio;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class RelatorioFiltroRequest {
    private String dataInicial;
    private String dataFinal;
    private String anoLetivo;
    private String turma;
    private String professor;
    private String disciplina;
    private String aluno;
}