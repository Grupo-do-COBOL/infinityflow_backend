package site.infinityflow.entities.sistema;

import jakarta.persistence.*;
import lombok.Builder;
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
    Integer id;
    String nome;
    String parentesco;
    String email;
    Long telefoneCelular;
    Long telefoneResidencial;
    @OneToOne
    Endereco endereco;
    @ManyToMany(mappedBy = "responsaveis")
    List<Aluno> alunos = new ArrayList<>();
}
