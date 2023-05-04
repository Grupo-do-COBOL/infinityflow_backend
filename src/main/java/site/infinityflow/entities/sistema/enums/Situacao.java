package site.infinityflow.entities.sistema.enums;

public enum Situacao {
    PRESENTE("P"),
    AUSENTE("A"),
    JUSTIFICADO("J");

    private String codigo;

    private Situacao(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public static Situacao converteParaEnum(String codigo) {
        for (Situacao situacao : Situacao.values()) {
            if (situacao.getCodigo().equals(codigo))
                return situacao;
        }
        throw new IllegalArgumentException("Código de situação inválido");
    }
}
