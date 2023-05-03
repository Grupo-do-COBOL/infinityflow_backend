package site.infinityflow.entities.sistema;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import site.infinityflow.entities.sistema.enums.Situacao;

import java.io.Serializable;

@Data
@Builder
@Entity
@Table(name = "tabela_presencas")
public class Presenca implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idPresenca;
    Situacao situacao;
    @OneToOne
    Aluno aluno;
    @OneToOne
    Aula aula;
}
