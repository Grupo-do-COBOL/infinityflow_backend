package site.infinityflow.entities.sistema;

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
    Integer id;
    LocalDate data;
    @ManyToOne
    Materia materia;
    @OneToOne
    DadosLetivos dadosLetivos;
}
