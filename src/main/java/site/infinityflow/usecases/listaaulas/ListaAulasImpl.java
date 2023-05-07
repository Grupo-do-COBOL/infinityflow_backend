package site.infinityflow.usecases.listaaulas;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.infinityflow.adapters.mysql.repository.AulasRepository;
import site.infinityflow.entities.sistema.Aula;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ListaAulasImpl implements ListaAulas {

    private final AulasRepository aulasRepository;

    @Override
    public List<Aula> execute(Integer idProfessor) {
        return aulasRepository.findAulas(LocalDate.now(), idProfessor);
    }
}
