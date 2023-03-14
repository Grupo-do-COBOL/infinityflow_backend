package site.infinityflow.adapters.rest.tabelausuarios.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.infinityflow.entities.Funcao;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TabelaUsuariosRequestDTO {



    private String nome;


    private String email;


    private Funcao funcao;


    private String senha;

}
