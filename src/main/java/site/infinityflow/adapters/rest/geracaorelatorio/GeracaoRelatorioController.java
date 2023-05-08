package site.infinityflow.adapters.rest.geracaorelatorio;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/sistema/v1")
public class GeracaoRelatorioController {

    @GetMapping("gerar_relatorios")
    public ResponseEntity<Void> gerarRelatorio(
            @RequestParam(required = false) String data,
            @RequestParam(required = false) String anoLetivo,
            @RequestParam(required = false) String turma,
            @RequestParam(required = false) String professor,
            @RequestParam(required = false) String disciplina,
            @RequestParam(required = false) String aluno
    ) {

        return ResponseEntity.ok().build();
    }
}
