/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.eti.kge.OSApiApplication.api.controller;

import br.eti.kge.OSApiApplication.domain.model.Cliente;
import br.eti.kge.OSApiApplication.domain.repository.ClienteRepository;
import java.util.List;

import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Amethyst
 */
@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/clientes/{clienteID}")

    public ResponseEntity<Cliente> buscar(@PathVariable Long clienteID) {

        Optional<Cliente> cliente = clienteRepository.findById(clienteID);

        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public List<Cliente> listas() {
//return clienteRepository.findAll();
        return clienteRepository.findAll();
//return clienteRepository.findByNomeContaning(" Silva ");

    }

    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionar(@Valid @RequestBody Cliente cliente) {

        return clienteRepository.save(cliente);
    }

    @PutMapping("/clientes/{clienteID}")
    public ResponseEntity<Cliente> atualizar(@Valid @PathVariable Long clienteID,
            @RequestBody Cliente cliente) {

        // Verifica se o cliente existe
        if (!clienteRepository.existsById(clienteID)) {
            return ResponseEntity.notFound().build();
        }
        cliente.setId(clienteID);
        cliente = clienteRepository.save(cliente);
        return ResponseEntity.ok(cliente);
    }

    
    //excluir clientes
    @DeleteMapping("/clientes/{clienteID}")
    public ResponseEntity<Void> excluir(@PathVariable Long clienteID) {
        //VERIFICA SE O CLIENTE EXISTE OU NÃO

        if (!clienteRepository.existsById(clienteID)) {
            return ResponseEntity.notFound().build();
        }

        clienteRepository.deleteById(clienteID);
        return ResponseEntity.noContent().build();
    }

}
