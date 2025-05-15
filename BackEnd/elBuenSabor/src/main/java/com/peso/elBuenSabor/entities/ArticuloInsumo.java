package com.peso.elBuenSabor.entities;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
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

    private String nombre;
    @NotNull
    private String denominacion;
    @NotNull
    @Column(length = 1000)
    private String descripcion;

    @Column(name = "url_imagen")
    private String urlImagen;

    @NotNull
    @Column(name = "precio_compra")
    private BigDecimal precioCompra;

    @NotNull
    @Column(name = "stock_actual")
    private BigDecimal stockActual;

    @NotNull
    @Column(name = "stock_minimo")
    private BigDecimal stockMinimo;

    @NotNull
    @Column(name = "unidad_medida")
    private String unidadMedida;

    @NotNull
    @Column(name = "fecha_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta;

    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @Column(name = "fecha_baja")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaBaja;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "ArticuloInsumo_id")
    private List<DetallePedido> detallePedidos = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "articulo_insumo_id")
    private List<DetalleArticuloManufacturado> detalleArticuloManufacturados = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "articulo_insumo_id")
    private List<DetalleFactura> detalleFacturas = new ArrayList<>();

}
