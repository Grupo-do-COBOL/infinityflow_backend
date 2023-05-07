package site.infinityflow.entities.sistema.enums;

public enum Situacao {
    PRESENTE('P'),
    AUSENTE('A'),
    JUSTIFICADO('J');

    private char codigo;

    private Situacao(char codigo) {
        this.codigo = codigo;
    }

    public char getCodigo() {
        return codigo;
    }

    public static Situacao converteParaEnum(char codigo) {
        for (Situacao situacao : Situacao.values()) {
            if (situacao.getCodigo() == codigo)
                return situacao;
        }
        throw new IllegalArgumentException("Código de situação inválido");
    }
}
