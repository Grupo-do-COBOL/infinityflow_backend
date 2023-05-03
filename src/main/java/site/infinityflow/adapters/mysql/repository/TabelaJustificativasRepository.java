package site.infinityflow.adapters.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.infinityflow.entities.sistema.Endereco;
import site.infinityflow.entities.sistema.Justificativa;

public interface TabelaJustificativasRepository extends JpaRepository<Justificativa, Integer> {
}
