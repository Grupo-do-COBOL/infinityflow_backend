package site.infinityflow.usecases.gerarelatorio;

import java.util.List;

public interface GeraRelatorioAluno {
    List<PresencaAluno> execute(RelatorioFiltroRequest relatorioFiltroRequest);
}
