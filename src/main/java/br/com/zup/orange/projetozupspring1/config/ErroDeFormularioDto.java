package br.com.zup.orange.projetozupspring1.config;

public class ErroDeFormularioDto {

    private String campo;
    private String erro;

    public ErroDeFormularioDto(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }
}
