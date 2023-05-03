package site.infinityflow.adapters.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.infinityflow.entities.sistema.Materia;
import site.infinityflow.entities.sistema.Presenca;

public interface TabelaPresencasRepository extends JpaRepository<Presenca, Integer> {
}
