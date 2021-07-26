package br.com.zup.orange.projetozupspring1.form;

import br.com.zup.orange.projetozupspring1.modelo.Aluno;
import br.com.zup.orange.projetozupspring1.valiacao.ValidaNascMenor18;
import org.hibernate.type.LocalDateType;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class AlunoForm {

    @NotBlank @Length(max = 30)
    private String nome;
    @NotBlank @Email @Length(max = 30)
    private String email;
    @NotNull
    @DateTimeFormat
    @ValidaNascMenor18
    private LocalDate dataNascimento;

    private LocalDateTime dataCadastro = LocalDateTime.now();


    public AlunoForm(String nome, String email, LocalDate dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Aluno toEntity() {
        Aluno aluno = new Aluno();
        aluno.setNome(this.getNome());
        aluno.setEmail(this.getEmail());
        aluno.setDataNascimento(this.getDataNascimento());

        return aluno;
    }
}
