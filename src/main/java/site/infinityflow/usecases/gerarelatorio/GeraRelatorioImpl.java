package site.infinityflow.usecases.gerarelatorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.infinityflow.adapters.mysql.repository.PresencasRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class GeraRelatorioImpl implements GeraRelatorio {

    @Autowired
    private PresencasRepository presencasRepository;

    @Override
    public List<PresencaAluno> execute(RelatorioFiltroRequest relatorioFiltroRequest) {
        var objetoPresencas = presencasRepository.findPresencasAlunos(relatorioFiltroRequest.getDataInicial(),
                relatorioFiltroRequest.getDataFinal(), relatorioFiltroRequest.getAluno(), relatorioFiltroRequest.getDisciplina());
        List<PresencaAluno> listaPresencas = new ArrayList<>();
        objetoPresencas.forEach(o -> listaPresencas.add(PresencaAluno.builder()
                .idAluno((Integer) o[0])
                .nomeAluno((String) o[1])
                .disciplina((String) o[2])
                .turma((String) o[3])
                .periodo((String) o[4])
                .bimestre((Integer) o[5])
                .presencas((Long) o[6])
                .faltas((Long) o[7])
                .build()));
        return listaPresencas;
    }
}
