package com.banco.xyz.cuentas.controller;

import com.banco.xyz.cuentas.model.Cuenta;
import com.banco.xyz.cuentas.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/cuentas")
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    @PostMapping
    public Mono<Cuenta> crearCuenta(@RequestBody Cuenta cuenta) {
        return cuentaService.crearCuenta(cuenta);
    }

    @GetMapping("/{id}")
    public Mono<Cuenta> obtenerCuentaPorId(@PathVariable String id) {
        return cuentaService.obtenerCuentaPorId(id);
    }

    @PutMapping("/{id}/depositar")
    public Mono<Cuenta> depositar(@PathVariable String id, @RequestParam Double monto) {
        return cuentaService.depositar(id, monto);
    }

    @PutMapping("/{id}/retirar")
    public Mono<Cuenta> retirar(@PathVariable String id, @RequestParam Double monto) {
        return cuentaService.retirar(id, monto);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> eliminarCuenta(@PathVariable String id) {
        return cuentaService.eliminarCuenta(id);
    }

    @GetMapping
    public Flux<Cuenta> listarCuentas() {
        // Este método debería retornar una lista de todas las cuentas, similar al listarClientes
        // Para esta implementación, se puede agregar un método en el servicio para manejar esta consulta.
        return cuentaService.listarCuentas();
    }
}

