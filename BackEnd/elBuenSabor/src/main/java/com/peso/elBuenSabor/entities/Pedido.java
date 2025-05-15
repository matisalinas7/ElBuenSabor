package com.peso.elBuenSabor.entities;

import com.peso.elBuenSabor.enums.EstadoPedido;
import com.peso.elBuenSabor.enums.FormaPago;
import com.peso.elBuenSabor.enums.TipoEnvio;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pedido")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pedido extends Base {

    @NotNull
    @Column(name = "fecha_pedido")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPedido;

    @NotNull
    @Column(name = "hora_estimada_finalizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaEstimadaFinalizacion;

    @Transient
    @NotNull
    @Column(name = "total")
    private BigDecimal total;

    @NotNull
    @Column(name = "total_costo")
    private BigDecimal totalCosto;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EstadoPedido estado;

    @NotNull
    @Column(name = "tipo_envio")
    @Enumerated(EnumType.STRING)
    private TipoEnvio tipoEnvio;

    @NotNull
    @Column(name = "forma_pago")
    @Enumerated(EnumType.STRING)
    private FormaPago formaPago;

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

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "factura_id")
    private Factura factura;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "mpDatos_id")
    private MPDatos mpDatos;

    @ManyToOne
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "pedido_id")
    private List<DetallePedido> detallePedidos = new ArrayList<>();

    public void agregarDetalle(DetallePedido detallePedido){

        detallePedidos.add(detallePedido);
    }

    public void mostrarDetalles(){
        int contador = 0;
        for (DetallePedido detallePedido: detallePedidos){
            System.out.println("Línea numero: " + contador + ", Producto" + detallePedido.getArticuloManufacturado().getDenominacion() + ", cantidad pedida: " + detallePedido.getCantidad() + ", subtotal: " + detallePedido.getSubtotal());
            contador = contador + 1;
        }
    }

    public Double getTotal() {
        Double total = 0.0;
        for (DetallePedido detallePedido : detallePedidos) {
            total += detallePedido.getSubtotal();
        }
        return total;
    }

}
