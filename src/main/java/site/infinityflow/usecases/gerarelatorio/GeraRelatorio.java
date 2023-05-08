package site.infinityflow.usecases.gerarelatorio;

public interface GeraRelatorio {
    RelatorioResponse execute(RelatorioFiltroRequest relatorioFiltroRequest);
}
