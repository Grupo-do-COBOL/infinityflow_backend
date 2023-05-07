package site.infinityflow.adapters.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.infinityflow.entities.sistema.Aluno;

import java.util.List;

@Repository
public interface AlunosRepository extends JpaRepository<Aluno, Integer> {
    List<Aluno> findAllByDadosLetivosId(Integer dadosLetivos);
}
