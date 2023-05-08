package site.infinityflow.usecases.gerarelatorio;

import lombok.Builder;

@Builder
public class RelatorioResponse {
    String filtro;
    Integer faltas;
    Integer presenca;
}
