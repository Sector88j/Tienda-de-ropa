package com.ventas.springboot.modelo.entidades.entity;

import com.ventas.springboot.modelo.entidades.enumeradores.Vestimenta;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "estantes")
public class Estante implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "numero_estante", nullable = false)
    private Integer nroEstante;

    @Column(name = "tamaño_estante")
    private String medidas;

    @Column(name = "cantidad_ropa")
    private Integer cantidadRopa;

    @Column(name = "tipo_vestimenta")
    @Enumerated(EnumType.STRING)
    private Vestimenta vestimenta;

    @ManyToOne(
            optional = true,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinColumn(
            name = "bodega_id",
            foreignKey = @ForeignKey(name = "FK_BODEGA_ID")
    )
    private Bodega bodega;

    public Estante(){

    }

    public Estante(Integer id, Integer nroEstante, String medidas, Integer cantidadRopa, Vestimenta vestimenta) {
        this.id = id;
        this.nroEstante = nroEstante;
        this.medidas = medidas;
        this.cantidadRopa = cantidadRopa;
        this.vestimenta = vestimenta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNroEstante() {
        return nroEstante;
    }

    public void setNroEstante(Integer nroEstante) {
        this.nroEstante = nroEstante;
    }

    public String getMedidas() {
        return medidas;
    }

    public void setMedidas(String medidas) {
        this.medidas = medidas;
    }

    public Integer getCantidadRopa() {
        return cantidadRopa;
    }

    public void setCantidadRopa(Integer cantidadRopa) {
        this.cantidadRopa = cantidadRopa;
    }

    public Vestimenta getVestimenta() {
        return vestimenta;
    }

    public void setVestimenta(Vestimenta vestimenta) {
        this.vestimenta = vestimenta;
    }


    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }

    @Override
    public String toString() {
        return "Estante{" +
                "id=" + id +
                ", nroEstante=" + nroEstante +
                ", medidas='" + medidas + '\'' +
                ", cantidadRopa=" + cantidadRopa +
                ", vestimenta=" + vestimenta +
                ", bodega=" + bodega +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estante estante = (Estante) o;
        return id.equals(estante.id) && nroEstante.equals(estante.nroEstante);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, nroEstante);
    }
}
