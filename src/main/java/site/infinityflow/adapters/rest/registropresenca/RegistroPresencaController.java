package site.infinityflow.adapters.rest.registropresenca;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.infinityflow.adapters.rest.registropresenca.dto.AlunoResponseDTO;
import site.infinityflow.adapters.rest.registropresenca.dto.AulaResponseDTO;
import site.infinityflow.adapters.rest.registropresenca.dto.PresencaRequestDTO;
import site.infinityflow.adapters.rest.registropresenca.mapper.ListaAulasResponseMapper;
import site.infinityflow.adapters.rest.registropresenca.mapper.ListaAlunosResponseMapper;
import site.infinityflow.adapters.rest.registropresenca.mapper.ListaPresencasRequestMapper;
import site.infinityflow.usecases.listaalunos.ListaAlunos;
import site.infinityflow.usecases.listaaulas.ListaAulas;
import site.infinityflow.usecases.registrapresenca.RegistraPresenca;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/sistema/v1")
public class RegistroPresencaController {

    private final RegistraPresenca registraPresenca;
    private final ListaPresencasRequestMapper listaPresencasRequestMapper;
    private final ListaAlunos listaAlunos;
    private final ListaAlunosResponseMapper listaAlunosResponseMapper;
    private final ListaAulas listaAulas;
    private final ListaAulasResponseMapper listaAulasResponseMapper;

    @PostMapping("registrar_presencas")
    public ResponseEntity<Void> registrarPresencas(@RequestBody PresencaRequestDTO presencasDTO) {
        registraPresenca.execute(listaPresencasRequestMapper.mapDtoToRequest(presencasDTO));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("lista_aulas")
    public ResponseEntity<List<AulaResponseDTO>> listarAulas(@RequestParam Integer idProfessor) {
        List<AulaResponseDTO> aulas = listaAulasResponseMapper.mapEntityToDto(listaAulas.execute(idProfessor));
        return ResponseEntity.ok().body(aulas);
    }

    @GetMapping("lista_alunos")
    public ResponseEntity<List<AlunoResponseDTO>> listarAlunos(@RequestParam Integer idDadosLetivos) {
        List<AlunoResponseDTO> alunos = listaAlunosResponseMapper.mapEntityToDto(listaAlunos.execute(idDadosLetivos));
        return ResponseEntity.ok().body(alunos);
    }

}
