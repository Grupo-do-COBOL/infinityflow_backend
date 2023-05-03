package site.infinityflow.entities.sistema;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.sql.Blob;

@Data
@Builder
@Entity
@Table(name = "tabela_justificativas")
public class Justificativa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idJustificativa;
    String justificativa;
    Blob atestado;
    @OneToOne
    Presenca presenca;
}
