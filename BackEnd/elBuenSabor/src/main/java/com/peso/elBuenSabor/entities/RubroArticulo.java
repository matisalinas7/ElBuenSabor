package com.peso.elBuenSabor.entities;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "rubro_articulo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RubroArticulo extends Base{

    @NotNull
    private String denominacion;

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
    @JoinColumn(name = "rubro_articulo_id")
    private List<ArticuloInsumo> articulosInsumos = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "rubro_articulo_id")
    private List<ArticuloManufacturado> articulosManufacturados = new ArrayList<>();

    @ManyToOne()
    @JoinColumn(name = "id_rubro_padre")
    private RubroArticulo rubroPadre;

// agregue esto
    @OneToMany(mappedBy = "rubroPadre")
    private List<RubroArticulo> subRubros;

    public RubroArticulo(String denominacion, RubroArticulo rubroPadre) {
        this.denominacion = denominacion;
        this.rubroPadre = rubroPadre;
    }

    public void setSubRubros(List<RubroArticulo> subRubros) {
        this.subRubros.clear();
        this.subRubros.addAll(subRubros);
    }

}
