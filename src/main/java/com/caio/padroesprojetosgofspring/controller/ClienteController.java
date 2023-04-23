package com.caio.padroesprojetosgofspring.controller;

import com.caio.padroesprojetosgofspring.model.Cliente;
import com.caio.padroesprojetosgofspring.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public List<Cliente> getAll(){

        return service.getAll();

    }

    @GetMapping("/{id}")
    Cliente GetById(@PathVariable Long id){

        return service.getById(id);

    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Cliente cliente){

        service.update(cliente, id);

    }

    @PostMapping
    public Cliente create(@RequestBody Cliente cliente){

        return service.create(cliente);

    }

    @DeleteMapping
    public void delete(Long id){

        service.delete(id);

    }

}
