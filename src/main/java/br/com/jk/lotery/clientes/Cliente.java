package br.com.jk.lotery.clientes;

import br.com.jk.lotery.clientes.apostas.Aposta;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String email;
    @OneToMany(mappedBy = "cliente")
    private List<Aposta> apostas;


    public Cliente(String email) {
        this.email = email;
    }

    @Deprecated //não utilizar, apenas para funcionamento do spring data
    public Cliente() {
    }


}
