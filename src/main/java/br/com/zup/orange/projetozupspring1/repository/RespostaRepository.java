package br.com.zup.orange.projetozupspring1.repository;

import br.com.zup.orange.projetozupspring1.modelo.Resposta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespostaRepository extends JpaRepository<Resposta, Long> {

    //Verifica se existe registro de Aluno na tabela de respostas
    boolean existsByAlunoId(Long id);
}
