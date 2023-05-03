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
@Table(name = "tabela_dados_letivos")
public class DadosLetivos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String turma;
    String bimestre;
    Integer anoLetivo;
}
