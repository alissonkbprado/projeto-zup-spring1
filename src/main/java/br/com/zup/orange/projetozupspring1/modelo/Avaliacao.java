package br.com.zup.orange.projetozupspring1.modelo;

import javax.persistence.*;
import java.util.List;

@Entity
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    private String respostaMentor;

    @OneToMany(mappedBy = "avaliacao", fetch = FetchType.LAZY)
    private List<Resposta> respostaList;

    @OneToMany(mappedBy = "avaliacao", fetch = FetchType.LAZY)
    private List<Autoavaliacao> autoavaliacaoList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getRespostaMentor() {
        return respostaMentor;
    }

    public void setRespostaMentor(String respostaMentor) {
        this.respostaMentor = respostaMentor;
    }

    public List<Resposta> getRespostaList() {
        return respostaList;
    }

    public void setRespostaList(List<Resposta> respostaList) {
        this.respostaList = respostaList;
    }

    public List<Autoavaliacao> getAutoavaliacaoList() {
        return autoavaliacaoList;
    }

    public void setAutoavaliacaoList(List<Autoavaliacao> autoavaliacaoList) {
        this.autoavaliacaoList = autoavaliacaoList;
    }
}
