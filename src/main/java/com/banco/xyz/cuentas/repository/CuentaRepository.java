package com.banco.xyz.cuentas.repository;

import com.banco.xyz.cuentas.model.Cuenta;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CuentaRepository extends MongoRepository<Cuenta, String> {
    // Puedes agregar consultas personalizadas si es necesario
}
