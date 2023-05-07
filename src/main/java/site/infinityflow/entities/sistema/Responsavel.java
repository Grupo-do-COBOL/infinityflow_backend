package site.infinityflow.entities.sistema;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "tabela_responsaveis")
public class Responsavel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String parentesco;
    private String email;
    private Long telefoneCelular;
    private Long telefoneResidencial;
    @OneToOne
    private Endereco endereco;
    @JsonBackReference
    @ManyToMany(mappedBy = "responsaveis", fetch = FetchType.EAGER)
    private List<Aluno> alunos = new ArrayList<>();
}
