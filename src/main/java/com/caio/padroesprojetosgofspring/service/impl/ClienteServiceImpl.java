package com.caio.padroesprojetosgofspring.service.impl;

import com.caio.padroesprojetosgofspring.model.Cliente;
import com.caio.padroesprojetosgofspring.model.Endereco;
import com.caio.padroesprojetosgofspring.repository.ClienteRepository;
import com.caio.padroesprojetosgofspring.repository.EnderecoRepository;
import com.caio.padroesprojetosgofspring.service.ClienteService;
import com.caio.padroesprojetosgofspring.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;

    @Override
    public List<Cliente> getAll() {

        return clienteRepository.findAll();

    }

    @Override
    public Cliente getById(Long id) {

        return clienteRepository.findById(id).get();

    }

    @Override
    public Cliente create(Cliente cliente) {

        return saveAddress(cliente);

    }

    @Override
    public void update(Cliente cliente, Long id) {

        Optional<Cliente> clienteBd = clienteRepository.findById(id);

        if (clienteBd.isPresent()){
            saveAddress(cliente);
        }

    }

    @Override
    public void delete(Long id) {

        clienteRepository.deleteById(id);

    }

    private Cliente saveAddress(Cliente cliente){

        String cep = cliente.getEndereco().getCep();

        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {

            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;

        });

        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);

        return cliente;
    }
}
