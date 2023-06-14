package site.infinityflow.adapters.rest.geracaorelatorio;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import site.infinityflow.usecases.gerarelatorio.GeraRelatorioAluno;
import site.infinityflow.usecases.gerarelatorio.PresencaAluno;
import site.infinityflow.usecases.gerarelatorio.RelatorioFiltroRequest;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/sistema/v1")
public class GeracaoRelatorioController {
    private final GeraRelatorioAluno geraRelatorioAluno;

    @GetMapping("gerar_relatorios")
    public ResponseEntity<Void> gerarRelatorio(
            @RequestParam String dataInicial,
            @RequestParam String dataFinal,
            @RequestParam(required = false) String anoLetivo,
            @RequestParam(required = false) String turma,
            @RequestParam(required = false) String professor,
            @RequestParam(required = false) String disciplina,
            @RequestParam(required = false) String aluno
    ) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("gerar_relatorio_aluno")
    public ResponseEntity<List<PresencaAluno>> gerarRelatorio(
            @RequestParam String dataInicial,
            @RequestParam String dataFinal,
            @RequestParam String aluno
    ) {
        List<PresencaAluno> relatorioResponse = geraRelatorioAluno.execute(RelatorioFiltroRequest.builder()
                .dataInicial(dataInicial)
                .dataFinal(dataFinal)
                .aluno(aluno)
                .build());
        return ResponseEntity.ok().body(relatorioResponse);
    }
}
