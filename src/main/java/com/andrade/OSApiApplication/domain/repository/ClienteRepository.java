/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.andrade.OSApiApplication.domain.repository;

import com.andrade.OSApiApplication.domain.model.Cliente;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Amethyst
 */
@Repository
public class ClienteRepository {

    List<Cliente> findByNome(String nome);

    List<Cliente> findByNomeContaining(String nome);

    Cliente findByEmail(String email);
}

