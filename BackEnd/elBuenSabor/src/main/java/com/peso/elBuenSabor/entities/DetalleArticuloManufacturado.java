package com.peso.elBuenSabor.entities;

import jakarta.persistence.*;
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
@Table(name = "detalle_articulo_manufacturado")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DetalleArticuloManufacturado extends Base{

    @NotNull
    @Column(name = "cantidad")
    private BigDecimal cantidad;

    @NotNull
    @Column(name = "unidad_medida")
    private String unidadMedida;
}
