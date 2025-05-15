package com.peso.elBuenSabor.entities;

import jakarta.persistence.*;

import lombok.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;

@Entity
@Table(name = "detalle_factura")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DetalleFactura extends Base{

    @NotNull
    private Integer cantidad;

    @NotNull
    @Column(name = "subtotal")
    private BigDecimal subtotal;

}
