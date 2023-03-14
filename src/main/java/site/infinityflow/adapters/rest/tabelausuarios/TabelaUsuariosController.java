package site.infinityflow.adapters.rest.tabelausuarios;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import site.infinityflow.adapters.rest.tabelausuarios.dto.response.TabelaUsuariosResponseDTO;
import site.infinityflow.usecases.tabelausuarios.TabelaUsuariosUseCase;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class TabelaUsuariosController {

    private final TabelaUsuariosUseCase usuariosUseCase;

    @GetMapping("/home")
    public ResponseEntity<String> teste() {
        return ResponseEntity.ok("funciona");
    }

    @GetMapping("/usuarios/buscar_usuario")
    public Optional<TabelaUsuariosResponseDTO> buscarUsuario(@RequestParam Integer id) {
        return usuariosUseCase.buscarUsuario(id);

    }

    @GetMapping("/usuarios/buscar_por_email")
    public Optional<TabelaUsuariosResponseDTO> buscarPorEmail(@RequestParam String email){
        return usuariosUseCase.buscarPorEmail(email);
    }

    @GetMapping("/usuarios/buscar_por_nome")
    public Optional<TabelaUsuariosResponseDTO> buscarPorNome(@RequestParam String nome){
        return usuariosUseCase.buscarPorNome(nome);
    }

    @GetMapping("/usuarios")
    public List<TabelaUsuariosResponseDTO> buscarTodosUsuarios(){
        return usuariosUseCase.buscarTodosUsuarios();
    }
}
