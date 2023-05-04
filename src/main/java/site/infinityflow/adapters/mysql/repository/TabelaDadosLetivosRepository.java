package site.infinityflow.adapters.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.infinityflow.entities.sistema.Aula;
import site.infinityflow.entities.sistema.DadosLetivos;

@Repository
public interface TabelaDadosLetivosRepository extends JpaRepository<DadosLetivos, Integer> {
}
