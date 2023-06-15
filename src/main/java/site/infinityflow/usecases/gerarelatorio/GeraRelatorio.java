package site.infinityflow.usecases.gerarelatorio;

import java.util.List;

public interface GeraRelatorio {
    List<PresencaAluno> execute(RelatorioFiltroRequest relatorioFiltroRequest);
}
