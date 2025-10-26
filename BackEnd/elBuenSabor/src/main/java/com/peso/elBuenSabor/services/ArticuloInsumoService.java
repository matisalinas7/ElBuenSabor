package com.peso.elBuenSabor.services;

import com.peso.elBuenSabor.entities.ArticuloInsumo;

import java.util.List;

public interface ArticuloInsumoService extends BaseService<ArticuloInsumo, Long> {

//     Historia usuario #25 - Control de stock de ingredientes
    List<ArticuloInsumo> findArticuloInsumoByStockActualBajoStockMinimo();

    List<ArticuloInsumo> findArticuloInsumoByStockActualCercaStockMinimo(Double margen);

//
}

