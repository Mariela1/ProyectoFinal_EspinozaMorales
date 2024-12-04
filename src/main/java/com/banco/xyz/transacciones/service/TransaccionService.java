package com.banco.xyz.transacciones.service;

import com.banco.xyz.transacciones.model.Transaccion;
import com.banco.xyz.transacciones.repository.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.Optional;


@Service
public class TransaccionService {



    @Autowired
    private TransaccionRepository transaccionRepository;
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

    public Mono<Transaccion> obtenerTransaccionPorId(String id) {
        return transaccionRepository.findById(id);
    }


    public void eliminarTransaccion(String id) {
        // Lógica para eliminar la transacción
        transaccionRepository.deleteById(id);
    }

    // TransaccionService.java
    public Mono<Transaccion> guardarTransaccion(Transaccion transaccion) {
        return transaccionRepository.save(transaccion);  // Esto devuelve un Mono<Transaccion>
    }



}

