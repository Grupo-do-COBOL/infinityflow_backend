package site.infinityflow.adapters.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import site.infinityflow.entities.sistema.Aluno;
import site.infinityflow.entities.sistema.Aula;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AlunosRepository extends JpaRepository<Aluno, Integer> {
    @Query(value = "SELECT * " +
            "FROM infinityflow_db.tabela_alunos a " +
            "WHERE dados_letivos_id = (SELECT dados_letivos_id FROM tabela_aulas a2 WHERE a2.id = :aula)",
            nativeQuery = true)
    List<Aluno> findAlunos(Integer aula);
}
