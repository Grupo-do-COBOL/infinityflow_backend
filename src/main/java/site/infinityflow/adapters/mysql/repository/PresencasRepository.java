package site.infinityflow.adapters.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.infinityflow.entities.sistema.Presenca;

@Repository
public interface PresencasRepository extends JpaRepository<Presenca, Integer> {
}
