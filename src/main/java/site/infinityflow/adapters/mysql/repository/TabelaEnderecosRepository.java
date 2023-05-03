package site.infinityflow.adapters.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.infinityflow.entities.sistema.Endereco;

public interface TabelaEnderecosRepository extends JpaRepository<Endereco, Integer> {
}
