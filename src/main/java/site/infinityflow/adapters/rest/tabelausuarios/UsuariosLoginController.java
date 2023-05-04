package site.infinityflow.adapters.rest.tabelausuarios;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.infinityflow.adapters.rest.tabelausuarios.dto.request.AuthenticationRequestDTO;
import site.infinityflow.adapters.rest.tabelausuarios.dto.request.TabelaUsuariosRequestDTO;
import site.infinityflow.adapters.rest.tabelausuarios.dto.response.AuthenticationResponseDTO;
import site.infinityflow.usecases.tabelausuarios.UsuariosLoginUseCase;

@RestController
@RequestMapping("/api/v1/login")
@RequiredArgsConstructor
public class UsuariosLoginController {

    private final UsuariosLoginUseCase usuariosUseCase;


    @PostMapping("/registrar")
    public ResponseEntity<AuthenticationResponseDTO> registrarUsuario(@RequestBody TabelaUsuariosRequestDTO request){
        return ResponseEntity.ok(usuariosUseCase.registrar(request));
    }


    @PostMapping("/autenticacao")
    public ResponseEntity<AuthenticationResponseDTO> autenticarUsuario(@RequestBody AuthenticationRequestDTO request){
        return ResponseEntity.ok(usuariosUseCase.autenticar(request));
    }


}
