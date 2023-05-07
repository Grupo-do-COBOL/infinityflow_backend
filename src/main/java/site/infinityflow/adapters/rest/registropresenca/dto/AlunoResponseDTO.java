package site.infinityflow.adapters.rest.registropresenca.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AlunoResponseDTO {
    private Integer id;
    private String nome;
}