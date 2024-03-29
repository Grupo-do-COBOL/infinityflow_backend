package site.infinityflow.adapters.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.infinityflow.entities.sistema.Endereco;

@Repository
public interface EnderecosRepository extends JpaRepository<Endereco, Integer> {
}
