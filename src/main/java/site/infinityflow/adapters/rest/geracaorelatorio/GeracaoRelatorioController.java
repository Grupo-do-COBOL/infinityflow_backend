package site.infinityflow.adapters.rest.geracaorelatorio;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import site.infinityflow.usecases.gerarelatorio.GeraRelatorio;
import site.infinityflow.usecases.gerarelatorio.PresencaAluno;
import site.infinityflow.usecases.gerarelatorio.RelatorioFiltroRequest;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/sistema/v1")
public class GeracaoRelatorioController {
    private final GeraRelatorio geraRelatorio;


    @GetMapping("gerar_relatorios")
    public ResponseEntity<List<PresencaAluno>> gerarRelatorio(
            @RequestParam String dataInicial,
            @RequestParam String dataFinal,
            @RequestParam(required = false, defaultValue = "") String aluno,
            @RequestParam(required = false, defaultValue = "") String disciplina
    ) {
        List<PresencaAluno> relatorioResponse = geraRelatorio.execute(RelatorioFiltroRequest.builder()
                .dataInicial(dataInicial)
                .dataFinal(dataFinal)
                .aluno(aluno)
                .disciplina(disciplina)
                .build());
        return ResponseEntity.ok().body(relatorioResponse);
    }
}
