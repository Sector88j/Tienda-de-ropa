package com.ventas.springboot.modelo.entidades.entity;

import com.ventas.springboot.modelo.entidades.enumeradores.TipoRopa;
import com.ventas.springboot.modelo.entidades.enumeradores.Vestimenta;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@Entity
@Table(name = "ropas")
@PrimaryKeyJoinColumn(name = "producto_id")
public class Ropa extends Producto{
    private BigDecimal precio;

    @Column(name = "tipo_ropa")
    @Enumerated(EnumType.STRING)
    private TipoRopa tipoRopa;

    @Column(name = "Tipo_vestimenta")
    @Enumerated(EnumType.STRING)
    private Vestimenta vestimenta;

    @Column(name = "ropa")
    private String ropa;

    @OneToOne(
            optional = true,
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "almacen_id",
            foreignKey = @ForeignKey(name = "FX_ALMACEN_ID")
    )
    private Bodega bodega;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "material", column = @Column(name = "material")),
            @AttributeOverride(name = "colorDeTinte", column = @Column(name = "colordetinte"))
    })
    private Material material;


    public Ropa(){

    }

    public Ropa(Integer id, String nombre, String nombreMarca, String numeroArticulo, BigDecimal precio,
                TipoRopa tipoRopa, String ropa, Bodega bodega, Material material, Vestimenta vestimenta) {
        super(id, nombre, nombreMarca, numeroArticulo);
        this.precio = precio;
        this.tipoRopa = tipoRopa;
        this.ropa = ropa;
        this.bodega = bodega;
        this.material = material;
        this.vestimenta = vestimenta;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public TipoRopa getTipoRopa() {
        return tipoRopa;
    }

    public void setTipoRopa(TipoRopa tipoRopa) {
        this.tipoRopa = tipoRopa;
    }

    public String getRopa() {
        return ropa;
    }

    public void setRopa(String ropa) {
        this.ropa = ropa;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Vestimenta getVestimenta() {
        return vestimenta;
    }

    public void setVestimenta(Vestimenta vestimenta) {
        this.vestimenta = vestimenta;
    }

    @Override
    public String toString() {
        return super.toString() + "Ropa{" +
                "precio=" + precio +
                ", tipoRopa=" + tipoRopa +
                ", almace=" + bodega + ", ropa=" + ropa +
                '}';
    }
}
