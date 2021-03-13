package br.com.jk.lotery.clientes.apostas;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApostaRepository extends JpaRepository<Aposta, Long> {

    boolean existsByNumerosApostados(String numeros);

    List<Aposta> findAllByCliente_Email(String email);
    }
