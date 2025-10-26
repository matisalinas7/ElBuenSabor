package com.peso.elBuenSabor.services;

import com.peso.elBuenSabor.entities.ArticuloInsumo;
import com.peso.elBuenSabor.repositories.ArticuloInsumoRepository;
import com.peso.elBuenSabor.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticuloInsumoServiceImpl extends BaseServiceImpl<ArticuloInsumo, Long> implements ArticuloInsumoService {

    @Autowired
    private ArticuloInsumoRepository articuloInsumoRepository;

    public ArticuloInsumoServiceImpl(BaseRepository<ArticuloInsumo, Long> baseRepository) {
        super(baseRepository);
    }
//    Historia usuario #25 - Control de stock de ingredientes
    @Override
    public List<ArticuloInsumo> findArticuloInsumoByStockActualBajoStockMinimo() {
        return articuloInsumoRepository.findArticuloInsumoByStockActualBajoStockMinimo();
    }

    @Override
    public List<ArticuloInsumo> findArticuloInsumoByStockActualCercaStockMinimo(Double margen) {
        return articuloInsumoRepository.findArticuloInsumoByStockActualCercaStockMinimo(margen);
    }

//

}
