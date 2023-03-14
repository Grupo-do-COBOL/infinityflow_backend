package site.infinityflow.adapters.rest.tabelausuarios;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.infinityflow.adapters.rest.tabelausuarios.dto.request.AuthenticationRequestDTO;
import site.infinityflow.adapters.rest.tabelausuarios.dto.request.TabelaUsuariosRequestDTO;
import site.infinityflow.adapters.rest.tabelausuarios.dto.response.AuthenticationResponseDTO;
import site.infinityflow.usecases.tabelausuarios.TabelaUsuariosLoginUseCase;

@RestController
@RequestMapping("/api/v1/login")
@RequiredArgsConstructor
public class TabelaUsuariosLoginController {

    private final TabelaUsuariosLoginUseCase usuariosUseCase;


    @PostMapping("/registrar")
    public ResponseEntity<AuthenticationResponseDTO> registrarUsuario(@RequestBody TabelaUsuariosRequestDTO request){
        return ResponseEntity.ok(usuariosUseCase.registrar(request));
    }


    @PostMapping("/autenticacao")
    public ResponseEntity<AuthenticationResponseDTO> autenticarUsuario(@RequestBody AuthenticationRequestDTO request){
        return ResponseEntity.ok(usuariosUseCase.autenticar(request));
    }


}
