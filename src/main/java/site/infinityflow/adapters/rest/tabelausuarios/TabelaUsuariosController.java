package site.infinityflow.adapters.rest.tabelausuarios;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/home")
public class TabelaUsuariosController {


    @GetMapping
    public ResponseEntity<String> teste(){
        return ResponseEntity.ok("funciona");
    }
}
