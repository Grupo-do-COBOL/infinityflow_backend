package site.infinityflow.adapters.rest.geracaorelatorio;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import site.infinityflow.usecases.gerarelatorio.GeraRelatorio;
import site.infinityflow.usecases.gerarelatorio.RelatorioFiltroRequest;
import site.infinityflow.usecases.gerarelatorio.RelatorioResponse;

import java.util.Objects;

@RequiredArgsConstructor
@RestController
@RequestMapping("/sistema/v1")
public class GeracaoRelatorioController {
    private final GeraRelatorio geraRelatorio;

    @GetMapping("gerar_relatorios")
    public ResponseEntity<Void> gerarRelatorio(
            @RequestParam(required = false) String dataInicial,
            @RequestParam(required = false) String dataFinal,
            @RequestParam(required = false) String anoLetivo,
            @RequestParam(required = false) String turma,
            @RequestParam(required = false) String professor,
            @RequestParam(required = false) String disciplina,
            @RequestParam(required = false) String aluno
    ) {
        RelatorioResponse relatorioResponse = geraRelatorio.execute(RelatorioFiltroRequest.builder()
                .dataInicial(Objects.requireNonNullElse(dataInicial, ""))
                .dataFinal(Objects.requireNonNullElse(dataFinal, ""))
                .anoLetivo(Objects.requireNonNullElse(anoLetivo, ""))
                .disciplina(Objects.requireNonNullElse(disciplina, ""))
                .turma(Objects.requireNonNullElse(turma, ""))
                .professor(Objects.requireNonNullElse(professor, ""))
                .disciplina(Objects.requireNonNullElse(disciplina, ""))
                .aluno(Objects.requireNonNullElse(aluno, ""))
                .build());
        return ResponseEntity.ok().build();
    }
}
