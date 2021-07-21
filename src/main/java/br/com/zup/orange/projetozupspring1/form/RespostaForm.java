package br.com.zup.orange.projetozupspring1.form;

import br.com.zup.orange.projetozupspring1.modelo.Aluno;
import br.com.zup.orange.projetozupspring1.modelo.Avaliacao;
import br.com.zup.orange.projetozupspring1.modelo.Resposta;
import br.com.zup.orange.projetozupspring1.repository.AlunoRepository;
import br.com.zup.orange.projetozupspring1.repository.AvaliacaoRepository;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class RespostaForm {


    @NotNull
    @NumberFormat
    Long idAluno;

    @NotNull
    @NumberFormat
    Long idAvaliacao;

    @NotBlank
    @NotNull
    @NumberFormat
    String descricao;

    public Long getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Long idAluno) {
        this.idAluno = idAluno;
    }

    public Long getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(Long idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Resposta toEntity() {
        Aluno aluno = new Aluno();
        aluno.setId(this.getIdAluno());

        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setId(this.idAvaliacao);

        Resposta resposta = new Resposta();
        resposta.setAluno(aluno);
        resposta.setAvaliacao(avaliacao);
        resposta.setDescricao(this.descricao);

        return resposta;
    }

    public boolean verifica(AlunoRepository alunoRepository, AvaliacaoRepository avaliacaoRepository) {
        Optional<Aluno> aluno = alunoRepository.findById(this.idAluno);
        Optional<Avaliacao> avaliacao = avaliacaoRepository.findById(this.idAvaliacao);

        if(!aluno.isPresent() || !avaliacao.isPresent()){
            return false;
        }

        return true;

    }
}

