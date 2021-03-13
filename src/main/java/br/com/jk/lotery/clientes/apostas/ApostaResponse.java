package br.com.jk.lotery.clientes.apostas;

public class ApostaResponse {

    private final String numerosApostados;

    public ApostaResponse(Aposta aposta){
        this.numerosApostados = aposta.getNumerosApostados();
    }

    public String getNumerosApostados() {
        return numerosApostados;
    }
}
