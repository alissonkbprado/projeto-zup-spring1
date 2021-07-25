package br.com.zup.orange.projetozupspring1.form;

import br.com.zup.orange.projetozupspring1.modelo.Aluno;
import br.com.zup.orange.projetozupspring1.modelo.Avaliacao;
import br.com.zup.orange.projetozupspring1.modelo.Resposta;
import br.com.zup.orange.projetozupspring1.repository.AlunoRepository;
import br.com.zup.orange.projetozupspring1.repository.AvaliacaoRepository;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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

    public RespostaForm(Long idAluno, Long idAvaliacao, String descricao) {
        this.idAluno = idAluno;
        this.idAvaliacao = idAvaliacao;
        this.descricao = descricao;
    }

    public Long getIdAluno() {
        return idAluno;
    }

    public Long getIdAvaliacao() {
        return idAvaliacao;
    }

    public String getDescricao() {
        return descricao;
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

        if(!alunoRepository.existsById(this.idAluno) || !avaliacaoRepository.existsById(this.idAvaliacao)){
            return false;
        }

        return true;
    }
}

