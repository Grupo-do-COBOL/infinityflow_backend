package site.infinityflow.usecases.listaaulas;

import site.infinityflow.entities.sistema.Aula;

import java.util.List;

public interface ListaAulas {
    List<Aula> execute(Integer idProfessor);
}
