package site.infinityflow.entities.sistema;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "tabela_materias")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Materia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @OneToOne
    private Professor professor;
    @OneToMany(mappedBy = "materia")
    @JsonIgnore
    private List<Aula> aulas = new ArrayList<>();
}
