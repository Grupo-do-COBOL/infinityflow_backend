package site.infinityflow.adapters.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.infinityflow.entities.sistema.Professor;

@Repository
public interface TabelaProfessoresRepository extends JpaRepository<Professor, Integer> {
}
