package site.infinityflow.entities.sistema;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "tabela_materias")
public class Materia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String nome;
    @OneToOne
    Professor professor;
    @OneToMany(mappedBy = "materia", cascade = CascadeType.ALL)
    List<Aula> aulas = new ArrayList<>();
}
