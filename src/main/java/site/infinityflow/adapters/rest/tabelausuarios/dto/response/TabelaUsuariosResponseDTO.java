package site.infinityflow.adapters.rest.tabelausuarios.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import site.infinityflow.entities.Funcao;


@Getter
@Setter
@Builder
public class TabelaUsuariosResponseDTO {



    @JsonProperty("nome_usuario")
    public String nome;

    @JsonProperty("email_usuario")
    public String email;

    @JsonProperty("funcao_usuario")
    public Funcao funcao;
}
