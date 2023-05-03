package site.infinityflow.adapters.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.infinityflow.entities.sistema.Aula;
import site.infinityflow.entities.sistema.DadosLetivos;

public interface TabelaDadosLetivosRepository extends JpaRepository<DadosLetivos, Integer> {
}
