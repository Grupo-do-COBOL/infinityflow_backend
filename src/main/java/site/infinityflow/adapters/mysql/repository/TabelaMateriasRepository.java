package site.infinityflow.adapters.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.infinityflow.entities.sistema.Aluno;
import site.infinityflow.entities.sistema.Materia;

@Repository
public interface TabelaMateriasRepository extends JpaRepository<Materia, Integer> {
}
