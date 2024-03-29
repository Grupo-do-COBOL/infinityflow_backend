package site.infinityflow.adapters.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.infinityflow.entities.sistema.Justificativa;

@Repository
public interface JustificativasRepository extends JpaRepository<Justificativa, Integer> {
}
