package com.peso.elBuenSabor.repositories;

import com.peso.elBuenSabor.entities.ArticuloInsumo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloInsumoRepository extends BaseRepository<ArticuloInsumo, Long> {

//  Historia usuario #25 - Control de stock de ingredientes
    @Query("SELECT a FROM ArticuloInsumo a WHERE a.stockActual < a.stockMinimo")
    List<ArticuloInsumo> findArticuloInsumoByStockActualBajoStockMinimo();

    @Query("SELECT a FROM ArticuloInsumo a WHERE a.stockActual <= (a.stockMinimo + a.stockMinimo * :margen)")
    List<ArticuloInsumo> findArticuloInsumoByStockActualCercaStockMinimo(@Param("margen") Double margen);

//
}
