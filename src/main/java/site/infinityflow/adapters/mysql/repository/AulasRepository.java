package site.infinityflow.adapters.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import site.infinityflow.entities.sistema.Aula;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AulasRepository extends JpaRepository<Aula, Integer> {
    @Query(value = "SELECT * " +
            "FROM infinityflow_db.tabela_aulas " +
            "WHERE data = :data " +
            "AND materia_id IN(" +
            "SELECT id " +
            "FROM infinityflow_db.tabela_materias " +
            "WHERE professor_id = :professorId)",
            nativeQuery = true)
    List<Aula> findAulas(LocalDate data, Integer professorId);
}