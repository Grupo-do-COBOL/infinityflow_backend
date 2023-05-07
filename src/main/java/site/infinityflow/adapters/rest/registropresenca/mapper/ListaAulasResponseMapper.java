package site.infinityflow.adapters.rest.registropresenca.mapper;

import org.springframework.stereotype.Component;
import site.infinityflow.adapters.rest.registropresenca.dto.AulaResponseDTO;
import site.infinityflow.entities.sistema.Aula;

import java.util.List;

@Component
public class ListaAulasResponseMapper {
    public List<AulaResponseDTO> mapEntityToDto(List<Aula> aulas) {
        return aulas.stream()
                .map(a -> AulaResponseDTO.builder()
                        .idAula(a.getId())
                        .idDadoLetivo(a.getDadosLetivos().getId())
                        .materia(a.getMateria().getNome())
                        .anoLetivo(a.getDadosLetivos().getAnoLetivo())
                        .turma(a.getDadosLetivos().getTurma())
                        .periodo(a.getDadosLetivos().getPeriodo())
                        .bimestre(a.getDadosLetivos().getBimestre())
                        .build())
                .toList();
    }
}
