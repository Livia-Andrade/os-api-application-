/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.andrade.OSApiApplication.domain.service;

import com.andrade.OSApiApplication.domain.exception.DomainException;
import com.andrade.OSApiApplication.domain.model.Cliente;
import com.andrade.OSApiApplication.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Amethyst
 */
@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente) {
        Cliente clienteExistente = clienteRepository.findByEmail(cliente.getEmail());

        // Lembre-se que o método SAVE pode ser usado para atualizar um cliente também!!!
        // ID vazio --> Novo Registro
        // ID Preenchido --> Alterar existente
        // Verifica se o cliente existe
        if (clienteExistente != null && !clienteExistente.equals(cliente)) {
            // Lançar exception
            throw new DomainException("Já existe um cliente cadastrado com esse email!");
        }

        return clienteRepository.save(cliente);
    }

    public void excluir(Long clienteID) {
        clienteRepository.deleteById(clienteID);
    }
}
