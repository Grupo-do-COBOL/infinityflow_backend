package site.infinityflow.entities.sistema;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "tabela_professores")
public class Professor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String formacao;
    private String email;
    private String telefoneCelular;
    private String telefoneResidencial;
    @OneToOne
    private Endereco endereco;
}
