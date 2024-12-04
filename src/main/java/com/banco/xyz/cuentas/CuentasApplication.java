package com.banco.xyz.cuentas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@Profile("cuentas")
public class CuentasApplication {
    public static void main(String[] args) {
        SpringApplication.run(CuentasApplication.class, args);
    }
}

