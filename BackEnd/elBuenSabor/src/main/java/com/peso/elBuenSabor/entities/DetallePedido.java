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
    @Column(nullable = false)
    private Long cantidad;

    @NotNull
    @Column(nullable = false, name = "subtotal_costo")
    private BigDecimal subtotalCosto;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "articulo_manufacturado_id")
    private ArticuloManufacturado articuloManufacturado;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @Transient
    public BigDecimal getSubtotal() {
        if (articuloManufacturado != null && articuloManufacturado.getPrecioVenta() != null && cantidad != null) {
            return articuloManufacturado.getPrecioVenta()
                    .multiply(BigDecimal.valueOf(cantidad));
        }
        return BigDecimal.ZERO;
    }

}
