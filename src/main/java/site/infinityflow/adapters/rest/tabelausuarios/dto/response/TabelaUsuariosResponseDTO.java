package site.infinityflow.adapters.rest.tabelausuarios.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class TabelaUsuariosResponseDTO {


    @Id
    @JsonProperty("id_usuario")
    public Integer id;

    @JsonProperty("nome_usuario")
    public String nome;

    @JsonProperty("email_usuario")
    public String email;

    @JsonProperty("funcao_usuario")
    public String funcao;
}
