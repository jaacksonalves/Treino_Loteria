package br.com.jk.lotery.clientes.apostas;

import br.com.jk.lotery.clientes.Cliente;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "apostas")
public class Aposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String numerosApostados;
    @Column(updatable = false)
    private final LocalDateTime dataAposta = LocalDateTime.now();
    @ManyToOne
    private Cliente cliente;

    public Aposta(Cliente cliente, String numerosApostados) {
        this.cliente = cliente;
        this.numerosApostados = numerosApostados;
    }

    public Aposta() {
    }


    public String getNumerosApostados() {
        return numerosApostados;
    }
}
