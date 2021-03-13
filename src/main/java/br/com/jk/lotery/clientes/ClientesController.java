package br.com.jk.lotery.clientes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/clientes")
public class ClientesController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    @PostMapping
    public ResponseEntity<?> cadastraClientePorEmail(@Valid @RequestBody NovoClienteRequest request) {
        //verifica se já existe cliente cadastrado para esse email
        if (clienteRepository.existsByEmail(request.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente já cadastrado");
        }

        Cliente cliente = request.toModel();
        clienteRepository.save(cliente);

        return ResponseEntity.status(201).body("Cliente criado com sucesso");
    }
}
