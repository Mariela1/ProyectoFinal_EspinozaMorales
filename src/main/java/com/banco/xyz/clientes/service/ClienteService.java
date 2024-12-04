package com.banco.xyz.clientes.service;

import com.banco.xyz.clientes.model.Cliente;
import com.banco.xyz.clientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Mono<Cliente> crearCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Mono<Cliente> obtenerClientePorId(String id) {
        return clienteRepository.findById(id);
    }

    public Mono<Cliente> actualizarCliente(String id, Cliente cliente) {
        return clienteRepository.findById(id)
                .flatMap(existingClient -> {
                    existingClient.setNombre(cliente.getNombre());
                    existingClient.setApellido(cliente.getApellido());
                    existingClient.setDni(cliente.getDni());
                    existingClient.setEmail(cliente.getEmail());
                    return clienteRepository.save(existingClient);
                });
    }

    public Mono<Void> eliminarCliente(String id) {
        return clienteRepository.deleteById(id);
    }

    public Flux<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }
}
