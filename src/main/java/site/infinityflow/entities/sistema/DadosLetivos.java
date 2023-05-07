package site.infinityflow.entities.sistema;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "tabela_dados_letivos")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DadosLetivos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String turma;
    private String periodo;
    private Integer bimestre;
    private Integer anoLetivo;
}
