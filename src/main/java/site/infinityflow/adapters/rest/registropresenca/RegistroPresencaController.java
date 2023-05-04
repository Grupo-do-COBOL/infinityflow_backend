package site.infinityflow.adapters.rest.registropresenca;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.infinityflow.adapters.rest.registropresenca.dto.RegistraPresencaRequestDTO;
import site.infinityflow.adapters.rest.registropresenca.mapper.RegistraPresencaMapper;
import site.infinityflow.usecases.registrapresenca.RegistraPresenca;

@RequiredArgsConstructor
@RestController
@RequestMapping("/sistema/v1")
public class RegistroPresencaController {

    private final RegistraPresenca registraPresenca;
    private final RegistraPresencaMapper mapper;

    @PostMapping("registrar_presencas")
    public ResponseEntity<Void> registrarPresencas(@RequestBody RegistraPresencaRequestDTO presencaDTO) {
        registraPresenca.execute(mapper.mapDtoToRequest(presencaDTO));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
