package site.infinityflow.adapters.rest.tabelausuarios;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import site.infinityflow.adapters.rest.tabelausuarios.dto.response.TabelaUsuariosResponseDTO;
import site.infinityflow.usecases.tabelausuarios.TabelaUsuariosUseCase;

import java.util.Optional;

@RestController
public class TabelaUsuariosController {

    @Autowired
    private TabelaUsuariosUseCase usuariosUseCase;

    @GetMapping("/buscar_usuario")
    public Optional<TabelaUsuariosResponseDTO> buscarUsuario(@RequestParam Integer id){
        return usuariosUseCase.buscarUsuario(id);

    }
}
