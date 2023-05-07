package site.infinityflow.usecases.registrapresenca;

import jakarta.persistence.Transient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.infinityflow.adapters.mysql.repository.AlunosRepository;
import site.infinityflow.adapters.mysql.repository.AulasRepository;
import site.infinityflow.adapters.mysql.repository.PresencasRepository;
import site.infinityflow.entities.sistema.Aluno;
import site.infinityflow.entities.sistema.Aula;
import site.infinityflow.entities.sistema.Presenca;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class RegistraPresencaImpl implements RegistraPresenca {

    private final AlunosRepository alunosRepository;
    private final AulasRepository aulasRepository;
    private final PresencasRepository presencasRepository;

    @Override
    @Transient
    public void execute(RegistraPresencaRequest registraPresencasRequest) {
        List<Presenca> presencas = new ArrayList<>();
        for (var presencaRequest : registraPresencasRequest.getPresencasRequests()) {
            Presenca presenca = new Presenca();
            presenca.getId().setIdAluno(presencaRequest.getIdAluno());
            presenca.getId().setIdAula(registraPresencasRequest.getIdAula());
            presenca.setSituacao(presencaRequest.getSituacao().getCodigo());
            presencas.add(presenca);
        }
        presencasRepository.saveAll(presencas);
    }
}
