package com.banco.xyz.transacciones.service;

import com.banco.xyz.transacciones.model.Transaccion;
import com.banco.xyz.transacciones.repository.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TransaccionService {

    private final TransaccionRepository transaccionRepository;

    @Autowired
    public TransaccionService(TransaccionRepository transaccionRepository) {
        this.transaccionRepository = transaccionRepository;
    }

    public Mono<Transaccion> registrarTransaccion(Transaccion transaccion) {
        return transaccionRepository.save(transaccion);
    }

    public Flux<Transaccion> obtenerHistorial() {
        return transaccionRepository.findAll();
    }

    public Mono<Transaccion> obtenerPorId(String id) {
        return transaccionRepository.findById(id);
    }
}
