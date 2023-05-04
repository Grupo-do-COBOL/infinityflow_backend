package site.infinityflow.entities.sistema;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data

@Entity
@Table(name = "tabela_dados_letivos")
public class DadosLetivos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String turma;
    String periodo;
    String bimestre;
    Integer anoLetivo;
}
