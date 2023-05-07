package site.infinityflow.usecases.registrapresenca;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.infinityflow.adapters.mysql.repository.AlunosRepository;
import site.infinityflow.adapters.mysql.repository.AulasRepository;
import site.infinityflow.adapters.mysql.repository.PresencasRepository;
import site.infinityflow.entities.sistema.Aluno;
import site.infinityflow.entities.sistema.Aula;
import site.infinityflow.entities.sistema.Presenca;


@Service
@RequiredArgsConstructor
public class RegistraPresencaImpl implements RegistraPresenca {

    private final AlunosRepository alunosRepository;
    private final AulasRepository aulasRepository;
    private final PresencasRepository presencasRepository;

    @Override
    public void execute(RegistraPresencaRequest request) {
        Aluno aluno = alunosRepository.getReferenceById(request.getIdAluno());
        Aula aula = aulasRepository.getReferenceById(request.getIdAula());
        Presenca presenca = new Presenca();
        presenca.setAluno(aluno);
        presenca.setAula(aula);
        presenca.setSituacao(request.getSituacao().getCodigo());
        presencasRepository.save(presenca);
    }
}
