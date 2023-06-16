package site.infinityflow.adapters.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import site.infinityflow.entities.sistema.Presenca;

import java.util.List;

@Repository
public interface PresencasRepository extends JpaRepository<Presenca, Integer> {
    @Query(value = "SELECT " +
            "tp.id_aluno, " +
            "al.nome AS nome_aluno, " +
            "tm.nome AS materia, " +
            "CONCAT(CAST(dl.ano_letivo AS CHAR(20)), '-', dl.turma) as turma, " +
            "dl.periodo, " +
            "dl.bimestre, " +
            "COUNT(CASE WHEN situacao = 'P' THEN 1 END) AS presencas, " +
            "COUNT(CASE WHEN situacao = 'A' THEN 1 END) AS faltas " +
            "FROM tabela_presencas tp " +
            "INNER JOIN tabela_alunos al ON (al.id = tp.id_aluno) " +
            "INNER JOIN tabela_aulas ta ON (ta.id = tp.id_aula) " +
            "INNER JOIN tabela_materias tm ON (ta.materia_id = tm.id) " +
            "INNER JOIN tabela_dados_letivos dl on (al.dados_letivos_id = dl.id) " +
            "WHERE al.nome LIKE %:nomeAluno% " +
            "AND tm.nome LIKE %:nomeDisciplina% " +
            "AND ta.data BETWEEN :dataInicial AND :dataFinal " +
            "GROUP BY id_aluno, al.nome, materia, turma, periodo, bimestre",
            nativeQuery = true)
    List<Object[]> findPresencasAlunos(String dataInicial, String dataFinal, String nomeAluno, String nomeDisciplina);


    @Query(value = "SELECT * FROM (SELECT " +
            "    al.nome as nome_aluno, " +
            "    tm.nome as nome_materia, " +
            "    tr.nome, " +
            "    tr.email, " +
            "    ROUND((COUNT(CASE WHEN situacao = 'P' then 1 end) / (COUNT(CASE WHEN situacao = 'P' then 1 end) + COUNT(CASE WHEN situacao = 'A' then 1 end)))*100, 2) AS perc " +
            "    FROM tabela_presencas tp " +
            "    INNER JOIN tabela_alunos al on (al.id = tp.id_aluno) " +
            "    INNER JOIN tabela_aulas ta on (ta.id = tp.id_aula) " +
            "    INNER JOIN tabela_materias tm on (ta.materia_id = tm.id) " +
            "    inner join tabela_alunos_responsaveis tar on (tar.aluno_id = al.id) " +
            "    inner join tabela_responsaveis tr on (tr.id = tar.responsavel_id) " +
            "GROUP BY tp.id_aluno, " +
            "    tm.id, " +
            "    tm.nome, " +
            "    tr.nome, " +
            "    tr.email) x " +
            "WHERE x.perc < 80", nativeQuery = true)
    List<Object[]> findAlunosFaltantes();
}