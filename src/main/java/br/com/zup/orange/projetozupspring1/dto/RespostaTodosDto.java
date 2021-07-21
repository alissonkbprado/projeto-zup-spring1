package br.com.zup.orange.projetozupspring1.dto;

import br.com.zup.orange.projetozupspring1.modelo.Resposta;
import org.springframework.data.domain.Page;

public class RespostaTodosDto {

    String nomeAluno;
    String tituloAvaliacao;
    String resposta;

    public RespostaTodosDto(Resposta resposta) {
        this.nomeAluno = resposta.getAluno().getNome();
        this.tituloAvaliacao = resposta.getAvaliacao().getTitulo();
        this.resposta = resposta.getDescricao();
    }

    public static Page<RespostaTodosDto> converter(Page<Resposta> respostaList) {
        return respostaList.map(RespostaTodosDto::new);
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public String getTituloAvaliacao() {
        return tituloAvaliacao;
    }

    public String getResposta() {
        return resposta;
    }
}
