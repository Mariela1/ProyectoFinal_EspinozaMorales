package com.banco.xyz.cuentas.service;

import com.banco.xyz.cuentas.model.Cuenta;
import com.banco.xyz.cuentas.model.TipoCuenta;
import com.banco.xyz.cuentas.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;

    public Mono<Cuenta> crearCuenta(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    public Mono<Cuenta> obtenerCuentaPorId(String id) {
        return cuentaRepository.findById(id);
    }

    public Mono<Cuenta> actualizarCuenta(String id, Cuenta cuenta) {
        return cuentaRepository.findById(id)
                .flatMap(existingAccount -> {
                    existingAccount.setSaldo(cuenta.getSaldo());
                    existingAccount.setTipoCuenta(cuenta.getTipoCuenta());
                    return cuentaRepository.save(existingAccount);
                });
    }

    public Mono<Void> eliminarCuenta(String id) {
        return cuentaRepository.deleteById(id);
    }

    public Mono<Cuenta> depositar(String id, Double monto) {
        return cuentaRepository.findById(id)
                .flatMap(cuenta -> {
                    cuenta.setSaldo(cuenta.getSaldo() + monto);
                    return cuentaRepository.save(cuenta);
                });
    }

    public Mono<Cuenta> retirar(String id, Double monto) {
        return cuentaRepository.findById(id)
                .flatMap(cuenta -> {
                    if (cuenta.getSaldo() >= monto) {
                        cuenta.setSaldo(cuenta.getSaldo() - monto);
                        return cuentaRepository.save(cuenta);
                    }
                    return Mono.error(new InsufficientFundsException("Fondos insuficientes"));
                });
    }
}
