package site.infinityflow.adapters.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.infinityflow.entities.sistema.Aluno;
import site.infinityflow.entities.sistema.Materia;

public interface TabelaMateriasRepository extends JpaRepository<Materia, Integer> {
}
