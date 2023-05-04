package site.infinityflow.adapters.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.infinityflow.entities.sistema.Presenca;
import site.infinityflow.entities.sistema.Responsavel;

@Repository
public interface TabelaResponsaveisRepository extends JpaRepository<Responsavel, Integer> {
}
