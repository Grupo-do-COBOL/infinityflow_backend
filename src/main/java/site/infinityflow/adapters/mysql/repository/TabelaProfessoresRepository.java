package site.infinityflow.adapters.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.infinityflow.entities.sistema.Professor;

public interface TabelaProfessoresRepository extends JpaRepository<Professor, Integer> {
}
