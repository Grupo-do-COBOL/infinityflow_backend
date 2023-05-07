package site.infinityflow.usecases.listaalunos;

import site.infinityflow.entities.sistema.Aluno;
import site.infinityflow.entities.sistema.DadosLetivos;

import java.util.List;

public interface ListaAlunos {
    List<Aluno> execute(Integer idDadosLetivos);
}
