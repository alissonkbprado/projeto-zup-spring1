package br.com.zup.orange.projetozupspring1.dto;

import br.com.zup.orange.projetozupspring1.util.GetDate;
import br.com.zup.orange.projetozupspring1.modelo.Aluno;
import org.springframework.data.domain.Page;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class AlunoDto {

    GetDate getDate = new GetDate();

    private String nome;
    private String email;

    public AlunoDto(Aluno aluno) {
        this.nome = aluno.getNome();
        this.email = aluno.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public static List<AlunoDto> converter(List<Aluno> alunoList) {
        return  alunoList.stream().map(AlunoDto::new).collect(Collectors.toList());
    }

    public static Page<AlunoDto> converter(Page<Aluno> alunoList) {
        return alunoList.map(AlunoDto::new);
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}
