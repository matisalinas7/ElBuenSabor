package com.peso.elBuenSabor.DTOs;
import com.peso.elBuenSabor.entities.ArticuloManufacturado;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class DTOrankingarticulomanufacturado {
    private ArticuloManufacturado articuloManufacturado;
    private Long cantidad;
    private BigDecimal total;
}
