package site.infinityflow.entities.sistema;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.sql.Blob;

@Data
@Entity
@Table(name = "tabela_justificativas")
public class Justificativa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String justificativa;
    private Blob atestado;
    @OneToOne
    private Presenca presenca;
}
