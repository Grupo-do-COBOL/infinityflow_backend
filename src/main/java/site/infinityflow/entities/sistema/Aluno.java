package site.infinityflow.entities.sistema;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
@Table(name = "tabela_alunos")
public class Aluno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer numMatricula;
    String nome;
    LocalDate dataNascimento;
    @OneToOne(mappedBy = "aluno", cascade = CascadeType.ALL)
    DadosLetivos dadosLetivos;
    @ManyToMany
    @JoinTable(name = "tabela_alunos_responsaveis",
            joinColumns = @JoinColumn(name = "num_matricula"),
            inverseJoinColumns = @JoinColumn(name = "id_responsavel")
    )
    Responsavel responsavel;
}
