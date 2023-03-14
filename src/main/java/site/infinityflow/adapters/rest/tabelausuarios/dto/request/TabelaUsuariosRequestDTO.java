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


    @JsonProperty("nome_usuario")
    private String nome;

    @JsonProperty("email_usuario")
    private String email;

    @JsonProperty("funcao_usuario")
    private Funcao funcao;

    @JsonProperty("senha_usuario")
    private String senha;

}
