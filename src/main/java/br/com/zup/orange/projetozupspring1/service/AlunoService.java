package br.com.zup.orange.projetozupspring1.service;

import br.com.zup.orange.projetozupspring1.form.AlunoForm;
import br.com.zup.orange.projetozupspring1.modelo.Aluno;
import br.com.zup.orange.projetozupspring1.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    public Aluno cadastra(AlunoForm alunoForm){
        Aluno aluno = new Aluno();
        aluno.setNome(alunoForm.getNome());
        aluno.setEmail(alunoForm.getEmail());
        aluno.setDataNascimento(alunoForm.getDataNascimento());

        alunoRepository.save(aluno);

        return aluno;
    }
}
