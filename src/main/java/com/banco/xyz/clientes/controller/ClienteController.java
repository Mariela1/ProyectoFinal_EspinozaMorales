package com.banco.xyz.clientes.controller;

import com.banco.xyz.clientes.model.Cliente;
import com.banco.xyz.clientes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;
import org.springframework.stereotype.Service;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public Mono<Cliente> crearCliente(@RequestBody Cliente cliente) {
        return clienteService.crearCliente(cliente);
    }

    @GetMapping("/{id}")
    public Mono<Cliente> obtenerClientePorId(@PathVariable String id) {
        return clienteService.obtenerClientePorId(id);
    }

    @PutMapping("/{id}")
    public Mono<Cliente> actualizarCliente(@PathVariable String id, @RequestBody Cliente cliente) {
        return clienteService.actualizarCliente(id, cliente);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> eliminarCliente(@PathVariable String id) {
        return clienteService.eliminarCliente(id);
    }

    @GetMapping
    public Flux<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }
}
