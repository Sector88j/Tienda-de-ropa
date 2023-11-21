package com.ventas.springboot.modelo.entidades.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class LugarOrigen implements Serializable {
    private String nombreDeFabrica;
    private String calle;
    private String codigoPostal;
    private String numero;

    public LugarOrigen(){
    }

    public LugarOrigen(String nombreDeFabrica, String calle, String codigoPostal, String numero) {
        this.nombreDeFabrica = nombreDeFabrica;
        this.calle = calle;
        this.codigoPostal = codigoPostal;
        this.numero = numero;
    }

    public String getNombreDeFabrica() {
        return nombreDeFabrica;
    }

    public void setNombreDeFabrica(String nombreDeFabrica) {
        this.nombreDeFabrica = nombreDeFabrica;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "LugarOrigen{" +
                "nombreDeFabrica='" + nombreDeFabrica + '\'' +
                ", calle='" + calle + '\'' +
                ", codigoPostal='" + codigoPostal + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }
}
