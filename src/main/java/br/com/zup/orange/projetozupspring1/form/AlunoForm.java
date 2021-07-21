package br.com.zup.orange.projetozupspring1.form;

import br.com.zup.orange.projetozupspring1.modelo.Aluno;
import br.com.zup.orange.projetozupspring1.repository.AlunoRepository;
import br.com.zup.orange.projetozupspring1.valiacao.ValidaNascMenor18;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class AlunoForm {

    @NotBlank @Length(max = 30)
    private String nome;
    @NotBlank @Email @Length(max = 30)
    private String email;
    @NotNull
    @DateTimeFormat
    @ValidaNascMenor18
    private LocalDate dataNascimento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Aluno toEntity() {
        Aluno aluno = new Aluno();
        aluno.setNome(this.getNome());
        aluno.setEmail(this.getEmail());
        aluno.setDataNascimento(this.getDataNascimento());

        return aluno;
    }
}
