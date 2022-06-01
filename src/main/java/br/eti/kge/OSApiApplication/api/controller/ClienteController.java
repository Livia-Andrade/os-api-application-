/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.eti.kge.OSApiApplication.api.controller;

import br.eti.kge.OSApiApplication.domain.model.Cliente;
import br.eti.kge.OSApiApplication.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
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
      
        @PostMapping("/clientes/clienteID")
        @ResponseStatus(HttpStatus.CREATED)
        public Cliente adiciona(@RequestBody Cliente cliente){
            
            return clienteRepository.save(cliente);
        
        
        }
    }
