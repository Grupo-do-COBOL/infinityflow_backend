package site.infinityflow.adapters.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.infinityflow.entities.sistema.Aluno;

@Repository
public interface TabelaAlunosRepository extends JpaRepository<Aluno, Integer> {
}