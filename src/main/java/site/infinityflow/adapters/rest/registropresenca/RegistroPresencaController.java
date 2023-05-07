package site.infinityflow.adapters.rest.registropresenca;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.infinityflow.adapters.rest.registropresenca.dto.AlunoResponseDTO;
import site.infinityflow.adapters.rest.registropresenca.dto.RegistraPresencaRequestDTO;
import site.infinityflow.adapters.rest.registropresenca.mapper.ListaAlunosResponseMapper;
import site.infinityflow.adapters.rest.registropresenca.mapper.RegistraPresencaRequestMapper;
import site.infinityflow.usecases.listaalunos.ListaAlunos;
import site.infinityflow.usecases.registrapresenca.RegistraPresenca;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/sistema/v1")
public class RegistroPresencaController {

    private final RegistraPresenca registraPresenca;
    private final RegistraPresencaRequestMapper registraPresencaRequestMapper;
    private final ListaAlunos listaAlunos;
    private final ListaAlunosResponseMapper listaAlunosResponseMapper;

    @PostMapping("registrar_presencas")
    public ResponseEntity<Void> registrarPresencas(@RequestBody RegistraPresencaRequestDTO presencaDTO) {
        registraPresenca.execute(registraPresencaRequestMapper.mapDtoToRequest(presencaDTO));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("lista_alunos")
    public ResponseEntity<List<AlunoResponseDTO>> listarAlunos(@RequestParam Integer idDadosLetivos) {
        List<AlunoResponseDTO> alunos = listaAlunosResponseMapper.mapEntityToDto(listaAlunos.execute(idDadosLetivos));
        return ResponseEntity.ok().body(alunos);
    }

}
