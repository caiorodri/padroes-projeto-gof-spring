package com.caio.padroesprojetosgofspring.service;

import com.caio.padroesprojetosgofspring.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ClienteService {

    List<Cliente> getAll();

    Cliente getById(Long id);

    Cliente create(Cliente cliente);

    void update(Cliente cliente, Long id);

    void delete(Long id);

}
