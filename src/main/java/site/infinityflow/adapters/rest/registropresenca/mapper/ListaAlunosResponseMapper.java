package site.infinityflow.adapters.rest.registropresenca.mapper;

import org.springframework.stereotype.Component;
import site.infinityflow.adapters.rest.registropresenca.dto.AlunoResponseDTO;
import site.infinityflow.entities.sistema.Aluno;

import java.util.List;

@Component
public class ListaAlunosResponseMapper {
    public List<AlunoResponseDTO> mapEntityToDto(List<Aluno> alunos) {
        return alunos.stream()
                .map(a -> AlunoResponseDTO.builder()
                        .id(a.getId())
                        .nome(a.getNome())
                        .build())
                .toList();
    }
}