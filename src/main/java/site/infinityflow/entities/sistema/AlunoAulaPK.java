package site.infinityflow.entities.sistema;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class AlunoAulaPK implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idAluno;
    private Integer idAula;
}
