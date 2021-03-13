package br.com.jk.lotery.clientes.apostas;

import br.com.jk.lotery.clientes.Cliente;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

public class NovaApostaRequest {

    @Email
    @NotBlank
    private String email;

    public NovaApostaRequest(@Email @NotBlank String email) {
        this.email = email;
    }

    @Deprecated
    public NovaApostaRequest() {
    }

    public String getEmail() {
        return email;
    }

    public String criaAposta() {
        GeradorLoteria geradorLoteria = new GeradorLoteria();
        List<Integer> numerosSorteados = geradorLoteria.geraNumerosLoteria();
        return numerosSorteados.toString();
    }

    public Aposta toModel(Cliente cliente, ApostaRepository apostaRepository) {
        while (apostaRepository.existsByNumerosApostados(criaAposta())){
            criaAposta();
        }

        return new Aposta(cliente, criaAposta());
    }
}
