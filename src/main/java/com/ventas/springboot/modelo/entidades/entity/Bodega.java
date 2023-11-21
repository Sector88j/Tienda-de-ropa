package com.ventas.springboot.modelo.entidades.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "almacenes")
public class Bodega implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "bloque_de_estantes")
    private int estantes;

    @Column(name = "numero_del_estante", unique = true, nullable = false)
    private String numero;

    @Column(name = "fecha_entrada")
    private LocalDateTime fechaEntrada;

    @Column(name = "fecha_salida")
    private LocalDateTime fechaSalida;

    @OneToMany(
            mappedBy = "bodega",
            fetch = FetchType.LAZY
    )
    private Set<Estante> estante;

    public Bodega(){

    }

    public Bodega(Integer id, int estantes, String numero) {
        this.id = id;
        this.estantes = estantes;
        this.numero = numero;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getEstantes() {
        return estantes;
    }

    public void setEstantes(int estantes) {
        this.estantes = estantes;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDateTime getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDateTime fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Set<Estante> getEstante() {
        return estante;
    }

    public void setEstante(Set<Estante> estante) {
        this.estante = estante;
    }

    @PrePersist
    private void antesDePersistir(){
        this.fechaEntrada = LocalDateTime.now();
    }

    @PreUpdate
    private void antesDeUpdate(){
        this.fechaSalida = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Bodega{" +
                "id=" + id +
                ", estantes=" + estantes +
                ", nombre='" + numero + '\'' +
                ", fechaEntrada=" + fechaEntrada +
                ", fechaSalida=" + fechaSalida +
                ", estante=" + estante +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bodega bodega = (Bodega) o;
        return id.equals(bodega.id) && numero.equals(bodega.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numero);
    }
}
