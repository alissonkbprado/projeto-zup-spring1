package br.com.zup.orange.projetozupspring1.repository;

import br.com.zup.orange.projetozupspring1.modelo.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
