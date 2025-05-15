package com.peso.elBuenSabor.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import lombok.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;

@Entity
@Table(name = "detalle_pedido")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DetallePedido extends Base{

    @NotNull
    private Long cantidad;

    @Transient
    @NotNull
    @Column(name = "subtotal")
    private Double subtotal;

    @NotNull
    @Column(name = "subtotal_costo")
    private BigDecimal subtotalCosto;

    @ManyToOne
    private ArticuloManufacturado articuloManufacturado;

    @ManyToOne
    private Pedido pedido;

    @Transient
    public Double getSubtotal() {
        if(this.articuloManufacturado.getPrecioVenta() != null && this.cantidad != null) {
            return this.cantidad * this.articuloManufacturado.getPrecioVenta();
        }else {
            return 0.0;
        }
    }

}
