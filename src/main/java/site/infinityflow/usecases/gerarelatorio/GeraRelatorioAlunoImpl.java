package site.infinityflow.usecases.gerarelatorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.infinityflow.adapters.mysql.repository.PresencasRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class GeraRelatorioAlunoImpl implements GeraRelatorioAluno {

    @Autowired
    private PresencasRepository presencasRepository;

    @Override
    public List<PresencaAluno> execute(RelatorioFiltroRequest relatorioFiltroRequest) {
        var objetoPresencas = presencasRepository.findPresencaAluno(relatorioFiltroRequest.getDataInicial(),
                relatorioFiltroRequest.getDataFinal(), relatorioFiltroRequest.getAluno());
        List<PresencaAluno> listaPresencas = new ArrayList<>();
        objetoPresencas.forEach(o -> listaPresencas.add(PresencaAluno.builder()
                .idAluno((Integer) o[0])
                .nomeAluno((String) o[1])
                .materia((String) o[2])
                .presencas((Long) o[3])
                .faltas((Long) o[4])
                .build()));
        return listaPresencas;
    }
}
