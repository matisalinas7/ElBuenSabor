package com.peso.elBuenSabor.entities;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "articulo_insumo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ArticuloInsumo extends Base{

    @NotNull
    @Column(nullable = false)
    private String nombre;

    @NotNull
    @Column(nullable = false, length = 1000)
    private String descripcion;

    @Column(name = "url_imagen")
    private String urlImagen;

    @NotNull
    @Column(nullable = false, name = "precio_compra")
    private BigDecimal precioCompra;

    @NotNull
    @Column(nullable = false, name = "stock_actual")
    private BigDecimal stockActual;

    @NotNull
    @Column(nullable = false, name = "stock_minimo")
    private BigDecimal stockMinimo;

    @NotNull
    @Column(nullable = false, name = "unidad_medida")
    private String unidadMedida;

    @NotNull
    @Column(nullable = false, name = "fecha_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta;

    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @Column(name = "fecha_baja")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaBaja;

}
