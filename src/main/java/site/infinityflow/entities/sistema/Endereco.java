package site.infinityflow.entities.sistema;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
@Table(name = "tabela_enderecos")
public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String rua;
    Integer numero;
    String bairro;
    String complemento;
    String estado;
    String cidade;
    Integer cep;
}
