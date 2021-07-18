package br.com.zup.orange.projetozupspring1.modelo;

import br.com.zup.orange.projetozupspring1.valiacao.ValidaNascMenor18;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Length(max = 30)
    private String nome;
    @NotBlank @Email
    @Length(max = 30)
    private String email;
    @NotNull
    @DateTimeFormat
    @ValidaNascMenor18
    private LocalDate dataNascimento;

    @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY)
    private List<Resposta> respostasList;

    @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY)
    private List<Autoavaliacao> autoavaliacaoList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<Resposta> getRespostasList() {
        return respostasList;
    }

    public void setRespostasList(List<Resposta> respostasList) {
        this.respostasList = respostasList;
    }

    public List<Autoavaliacao> getAutoavaliacaoList() {
        return autoavaliacaoList;
    }

    public void setAutoavaliacaoList(List<Autoavaliacao> autoavaliacaoList) {
        this.autoavaliacaoList = autoavaliacaoList;
    }
}
