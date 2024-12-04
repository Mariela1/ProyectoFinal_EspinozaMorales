package com.banco.xyz.transacciones.controller;

import com.banco.xyz.transacciones.model.Transaccion;
import com.banco.xyz.transacciones.service.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;
import org.springframework.stereotype.Controller;

@RestController
@RequestMapping("/api/transacciones")
public class TransaccionController {

    private final TransaccionService transaccionService;

    // Inyección de dependencias usando @Autowired
    @Autowired
    public TransaccionController(TransaccionService transaccionService) {
        this.transaccionService = transaccionService;
    }

    // Endpoint para registrar un depósito
    @PostMapping("/deposito")
    public Mono<Transaccion> registrarDeposito(@RequestBody Transaccion transaccion) {
        return transaccionService.registrarTransaccion(transaccion);
    }

    // Endpoint para registrar un retiro
    @PostMapping("/retiro")
    public Mono<Transaccion> registrarRetiro(@RequestBody Transaccion transaccion) {
        return transaccionService.registrarTransaccion(transaccion);
    }

    // Endpoint para registrar una transferencia
    @PostMapping("/transferencia")
    public Mono<Transaccion> registrarTransferencia(@RequestBody Transaccion transaccion) {
        return transaccionService.registrarTransaccion(transaccion);
    }

    // Endpoint para obtener el historial de transacciones
    @GetMapping("/historial")
    public Flux<Transaccion> obtenerHistorial() {
        return transaccionService.obtenerHistorial();
    }

    // Endpoint para obtener una transacción por su ID
    @GetMapping("/{id}")
    public Mono<Transaccion> obtenerPorId(@PathVariable String id) {
        return transaccionService.obtenerPorId(id);
    }
}
