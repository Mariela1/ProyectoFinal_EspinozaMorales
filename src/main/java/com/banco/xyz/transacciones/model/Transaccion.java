package com.banco.xyz.transacciones.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "transacciones")
public class Transaccion {
    @Id
    private String id;
    private String tipo;
    private Double monto;
    private String cuentaOrigen;
    private String cuentaDestino;
    private String descripcion;

    public Transaccion(String id, String tipo, Double monto, String cuentaOrigen, String cuentaDestino) {
        this.id = id;
        this.tipo = "desconocido";
        this.monto = monto;
        this.cuentaOrigen = "desconocida";
        this.cuentaDestino = "desconocida";
        this.descripcion = descripcion;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public String getTipo() {

        return tipo;
    }

    public void setTipo(String tipo) {

        this.tipo = tipo;
    }

    public Double getMonto() {

        return monto;
    }

    public void setMonto(Double monto) {

        this.monto = monto;
    }

    public String getCuentaOrigen() {

        return cuentaOrigen;
    }

    public void setCuentaOrigen(String cuentaOrigen) {

        this.cuentaOrigen = cuentaOrigen;
    }

    public String getCuentaDestino() {

        return cuentaDestino;
    }

    public void setCuentaDestino(String cuentaDestino) {

        this.cuentaDestino = cuentaDestino;
    }
}
