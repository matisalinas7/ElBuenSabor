package com.peso.elBuenSabor.services;

import com.peso.elBuenSabor.entities.Factura;
import com.peso.elBuenSabor.repositories.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface FacturaService extends BaseService<Factura, Long> {

    List<Factura> findFacturasByFechaBetween(Date fechaInicio, Date fechaFin);

}
