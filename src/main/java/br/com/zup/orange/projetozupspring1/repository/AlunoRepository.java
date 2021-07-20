package br.com.zup.orange.projetozupspring1.repository;

import br.com.zup.orange.projetozupspring1.modelo.Aluno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    List<Aluno> findByNome(String nome);

    Page<Aluno> findByNome(String nome, Pageable paginacao);
}
