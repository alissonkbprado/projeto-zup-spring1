package br.com.zup.orange.projetozupspring1.repository;

import br.com.zup.orange.projetozupspring1.modelo.Aluno;
import br.com.zup.orange.projetozupspring1.modelo.Teste;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TesteRepository extends CrudRepository<Teste, Long> {
    List<Aluno> findByNome(String nome);

    Page<Aluno> findByNome(String nome, Pageable paginacao);

    //verifica se existe Aluno com registro na tabela de respostas
    boolean existsByRespostasListAlunoId(Long id);
}
