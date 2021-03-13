package br.com.jk.lotery.clientes.apostas;

import br.com.jk.lotery.clientes.Cliente;
import br.com.jk.lotery.clientes.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/apostas")
public class ApostasController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ApostaRepository apostaRepository;

    @Transactional
    @PostMapping
    public ResponseEntity<ApostaResponse> cadastraApostaPorEmail(@Valid @RequestBody NovaApostaRequest request) {
        //Verifica se usuário existe, para não realizar aposta para email inexistente.
        if (!clienteRepository.existsByEmail(request.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário não encontrado");
        }
        Cliente cliente = clienteRepository.findByEmail(request.getEmail());

        Aposta novaAposta = request.toModel(cliente, apostaRepository);

        apostaRepository.save(novaAposta);

        return ResponseEntity.status(201).body(new ApostaResponse(novaAposta));

    }


    @GetMapping("/{email}")
    @Transactional(readOnly = true)
    public List<ApostaResponse> mostraTodasApostasPorEmail(@PathVariable("email") String email) {
        if (!clienteRepository.existsByEmail(email)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email não cadastrado");
        }

        List<Aposta> apostas = apostaRepository.findAllByCliente_Email(email);

        return apostas.stream().map(ApostaResponse::new).collect(Collectors.toList());
    }


}
