package com.peso.elBuenSabor.services;

import com.peso.elBuenSabor.DTOs.DTORankingProducto;
import com.peso.elBuenSabor.entities.ArticuloManufacturado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface ArticuloManufacturadoService extends BaseService<ArticuloManufacturado, Long> {

    List<ArticuloManufacturado> findByDenominacion(String denominacion) throws Exception;

    Page<ArticuloManufacturado> findByDenominacion(String denominacion, Pageable pageable) throws Exception;

    List<ArticuloManufacturado> findArticulosConPrecioMayorQue(BigDecimal precio) throws Exception;

    List<DTORankingProducto> findTopSellingProducts() throws Exception;

    List<DTORankingProducto> findTopSellingProductsByFecha(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)Date fechaIn, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFin) throws Exception;

}
