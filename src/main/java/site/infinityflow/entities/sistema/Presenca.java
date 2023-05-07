package site.infinityflow.entities.sistema;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.io.Serializable;

@Data
@Entity
@Table(name = "tabela_presencas")
public class Presenca implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    @Setter(AccessLevel.NONE)
    private AlunoAulaPK id = new AlunoAulaPK();
    private Character situacao;
}
