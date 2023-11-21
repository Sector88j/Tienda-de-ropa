package com.ventas.springboot.modelo.entidades.entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "productos")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "tipo"
)
public abstract class Producto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 60)
    //nombre en conjunto de productos
    private String nombre;

    @Column(nullable = false, length = 60)
    private String nombreMarca;

    @Column(nullable = false, unique = true, length = 10)
    private String numeroArticulo;

    //fecha de llegada exacta del producto
    @NotNull
    @Column(name = "fecha_de_llegada")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime fechaDeLlegada;

    @Autowired
    private LugarOrigen lugarOrigen;


    public Producto(){}

    public Producto(Integer id, String nombre, String nombreMarca, String numeroArticulo) {
        this.id = id;
        this.nombre = nombre;
        this.nombreMarca = nombreMarca;
        this.numeroArticulo = numeroArticulo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public String getNumeroArticulo() {
        return numeroArticulo;
    }

    public void setNumeroArticulo(String numeroArticulo) {
        this.numeroArticulo = numeroArticulo;
    }

    public LocalDateTime getFechaDeLlegada() {
        return fechaDeLlegada;
    }

    public void setFechaDeLlegada(LocalDateTime fechaDeLlegada) {
        this.fechaDeLlegada = fechaDeLlegada;
    }


    @PrePersist
    private void antesDePersistir(){
        this.fechaDeLlegada = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", nombreMarca='" + nombreMarca + '\'' +
                ", numeroArticulo='" + numeroArticulo + '\'' +
                ", fechaDeLlegada=" + fechaDeLlegada +
                '}';
    }
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return id.equals(producto.id) && numeroArticulo.equals(producto.numeroArticulo);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, numeroArticulo);
    }
}
