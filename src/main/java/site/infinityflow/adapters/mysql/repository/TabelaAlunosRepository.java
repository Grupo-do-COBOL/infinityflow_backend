package site.infinityflow.adapters.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.infinityflow.entities.sistema.Aluno;

public interface TabelaAlunosRepository extends JpaRepository<Aluno, Integer> {
}
