package com.peso.elBuenSabor.entities;


import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;


@Entity
@Table(name = "mp_datos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MPDatos extends Base {
    @Column(name = "mp_payment_id")
    private Long mpPaymentId;

    @Column(name = "mp_merchant_order_id")
    private Long mpMerchantOrderId;

    @Column(name = "mp_preference_id")
    private String mpPreferenceId;

    @Column(name = "mp_payment_type")
    private String mpPaymentType;

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

    @OneToOne
    @JoinColumn(name = "id_mp_datos")
    private MPDatos mpDatos;

//    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "pedido_id")
//    private Pedido pedido;

}
