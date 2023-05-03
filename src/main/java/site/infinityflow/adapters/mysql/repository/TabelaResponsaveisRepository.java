package site.infinityflow.adapters.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.infinityflow.entities.sistema.Presenca;
import site.infinityflow.entities.sistema.Responsavel;

public interface TabelaResponsaveisRepository extends JpaRepository<Responsavel, Integer> {
}
