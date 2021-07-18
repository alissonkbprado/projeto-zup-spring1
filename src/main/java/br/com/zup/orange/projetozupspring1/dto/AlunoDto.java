package br.com.zup.orange.projetozupspring1.dto;

import br.com.zup.orange.projetozupspring1.Util.GetDate;
import br.com.zup.orange.projetozupspring1.modelo.Aluno;

import java.time.format.DateTimeFormatter;

public class AlunoDto {

    GetDate getDate = new GetDate();

    private String nome;
    private String email;

    public AlunoDto(Aluno aluno) {
        this.nome = aluno.getNome();
        this.email = aluno.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}
