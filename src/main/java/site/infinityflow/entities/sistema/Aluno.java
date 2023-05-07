package site.infinityflow.entities.sistema;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "tabela_alunos")
public class Aluno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String nome;
    LocalDate dataNascimento;
    @OneToOne
    DadosLetivos dadosLetivos;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    @JoinTable(name = "tabela_alunos_responsaveis",
            joinColumns = @JoinColumn(name = "aluno_id"),
            inverseJoinColumns = @JoinColumn(name = "responsavel_id")
    )
    List<Responsavel> responsaveis = new ArrayList<>();
}
