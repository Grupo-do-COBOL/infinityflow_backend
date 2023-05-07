package site.infinityflow.entities.sistema;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "tabela_presencas")
public class Presenca implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Character situacao;
    @OneToOne
    private Aluno aluno;
    @OneToOne
    private Aula aula;
}
