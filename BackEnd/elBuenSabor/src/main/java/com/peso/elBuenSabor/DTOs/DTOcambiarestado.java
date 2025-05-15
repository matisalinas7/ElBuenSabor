package com.peso.elBuenSabor.DTOs;
import com.peso.elBuenSabor.enums.EstadoPedido;
import lombok.Data;
@Data
public class DTOcambiarestado {
    private Long idPedido;
    private EstadoPedido estadoPedido;
}
