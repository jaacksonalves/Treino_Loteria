package br.com.jk.lotery.clientes;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class NovoClienteRequest {

    @Email
    @NotBlank
    private String email;

    public NovoClienteRequest(@Email @NotBlank String email) {
        this.email = email;
    }

    @Deprecated //não utilizar, apenas para funcionamento do spring data
    public NovoClienteRequest() {
    }

    public String getEmail() {
        return email;
    }

    public Cliente toModel() {
        return new Cliente(email);
    }
}
