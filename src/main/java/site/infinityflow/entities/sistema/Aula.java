package site.infinityflow.entities.sistema;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "tabela_aulas")
public class Aula implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate data;
    private Boolean confirmacao;
    @ManyToOne
    private Materia materia;
    @OneToOne
    private DadosLetivos dadosLetivos;
}