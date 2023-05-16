package site.infinityflow.usecases.listaalunos;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.infinityflow.adapters.mysql.repository.AlunosRepository;
import site.infinityflow.entities.sistema.Aluno;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListaAlunosImpl implements ListaAlunos {

    private final AlunosRepository alunosRepository;

    @Override
    public List<Aluno> execute(Integer idAula) {
        return alunosRepository.findAlunos(idAula);
    }
}
