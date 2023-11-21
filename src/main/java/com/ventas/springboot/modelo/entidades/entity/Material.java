package com.ventas.springboot.modelo.entidades.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class Material implements Serializable {
    private String material;
    private String colorDeTinte;
    private String Calidad;

    public Material(String material, String colorDeTinte, String calidad) {
        this.material = material;
        this.colorDeTinte = colorDeTinte;
        Calidad = calidad;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColorDeTinte() {
        return colorDeTinte;
    }

    public void setColorDeTinte(String colorDeTinte) {
        this.colorDeTinte = colorDeTinte;
    }

    public String getCalidad() {
        return Calidad;
    }

    public void setCalidad(String calidad) {
        Calidad = calidad;
    }

    @Override
    public String toString() {
        return "Material{" +
                "material='" + material + '\'' +
                ", colorDeTinte='" + colorDeTinte + '\'' +
                ", Calidad='" + Calidad + '\'' +
                '}';
    }
}
