package site.infinityflow.adapters.mysql.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.infinityflow.entities.TabelaUsuariosEntity;


@Repository
public interface TabelaUsuariosRepository extends JpaRepository<TabelaUsuariosEntity, Integer> {
}
