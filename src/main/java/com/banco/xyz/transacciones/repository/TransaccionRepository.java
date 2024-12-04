package com.banco.xyz.transacciones.repository;

import com.banco.xyz.transacciones.model.Transaccion;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TransaccionRepository extends ReactiveMongoRepository<Transaccion, String> {
    // Métodos adicionales personalizados si los necesitas




}
