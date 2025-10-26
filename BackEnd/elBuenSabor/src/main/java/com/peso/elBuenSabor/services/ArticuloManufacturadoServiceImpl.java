package com.peso.elBuenSabor.services;

import com.peso.elBuenSabor.DTOs.DTORankingProducto;
import com.peso.elBuenSabor.entities.ArticuloManufacturado;
import com.peso.elBuenSabor.repositories.ArticuloManufacturadoRepository;
import com.peso.elBuenSabor.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticuloManufacturadoServiceImpl extends BaseServiceImpl<ArticuloManufacturado, Long> implements ArticuloManufacturadoService {


    @Autowired
    private ArticuloManufacturadoRepository articuloManufacturadoRepository;

    public ArticuloManufacturadoServiceImpl(BaseRepository<ArticuloManufacturado, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<ArticuloManufacturado> findByDenominacion(String denominacion) throws Exception {
        try {
            return articuloManufacturadoRepository.findByDenominacion(denominacion);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<ArticuloManufacturado> findByDenominacion(String denominacion, Pageable pageable) throws Exception {
        try {
            return articuloManufacturadoRepository.findByDenominacion(denominacion, pageable);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<ArticuloManufacturado> findArticulosConPrecioMayorQue(BigDecimal precio) throws Exception {
        try {
            List<ArticuloManufacturado> articulosManufacturados = articuloManufacturadoRepository.findArticulosConPrecioMayorQue(precio);
            return articulosManufacturados;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<DTORankingProducto> findTopSellingProducts() throws Exception {
        try {
            return articuloManufacturadoRepository.findTopSellingProducts().stream()
                    .map(row -> new DTORankingProducto(
                    (Long) row[0],
                    (String) row[1],
                    (Long) row[2]))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public List<DTORankingProducto> findTopSellingProductsByFecha(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)Date fechaIn, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFin) throws Exception {
        try {
            return articuloManufacturadoRepository.findTopSellingProductsByFecha(fechaIn, fechaFin).stream()
                    .map(row -> new DTORankingProducto(
                            (Long) row[0],
                            (String) row[1],
                            (Long) row[2]))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
