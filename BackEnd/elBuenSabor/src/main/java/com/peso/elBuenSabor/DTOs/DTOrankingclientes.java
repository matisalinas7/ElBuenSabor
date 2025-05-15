package com.peso.elBuenSabor.DTOs;
import com.peso.elBuenSabor.entities.Cliente;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class DTOrankingclientes {
    private Cliente cliente;
    private Long cantidadPedidos;
    private BigDecimal total;

    public DTOrankingclientes(Cliente cliente, Long cantidadPedidos, BigDecimal total) {
        this.cliente = cliente;
        this.cantidadPedidos = cantidadPedidos;
        this.total = total;
}
}