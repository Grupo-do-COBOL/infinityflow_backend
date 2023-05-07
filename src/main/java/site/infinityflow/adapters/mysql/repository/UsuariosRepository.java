package site.infinityflow.adapters.mysql.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.infinityflow.entities.security.UsuariosEntity;

import java.util.Optional;


@Repository
public interface UsuariosRepository extends JpaRepository<UsuariosEntity, Integer> {

    Optional<UsuariosEntity> findByEmail(String email);

    Optional<UsuariosEntity> findByNome(String nome);
}
