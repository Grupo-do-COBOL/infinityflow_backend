package site.infinityflow.adapters.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import site.infinityflow.entities.sistema.Presenca;
import site.infinityflow.usecases.gerarelatorio.PresencaAluno;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Repository
public interface PresencasRepository extends JpaRepository<Presenca, Integer> {
    @Query(value = "SELECT " +
            "tp.id_aluno, " +
            "al.nome AS nome_aluno, " +
            "tm.nome AS materia, " +
            "COUNT(CASE WHEN situacao = 'P' THEN 1 END) AS presencas, " +
            "COUNT(CASE WHEN situacao = 'A' THEN 1 END) AS faltas " +
            "FROM tabela_presencas tp " +
            "INNER JOIN tabela_alunos al ON (al.id = tp.id_aluno) " +
            "INNER JOIN tabela_aulas ta ON (ta.id = tp.id_aula) " +
            "INNER JOIN tabela_materias tm ON (ta.materia_id = tm.id) " +
            "WHERE al.nome LIKE %:nomeAluno% " +
            "AND ta.data BETWEEN :dataInicial AND :dataFinal " +
            "GROUP BY id_aluno, al.nome, tm.nome",
            nativeQuery = true)
    List<Object[]> findPresencaAluno(String dataInicial, String dataFinal, String nomeAluno);
}
