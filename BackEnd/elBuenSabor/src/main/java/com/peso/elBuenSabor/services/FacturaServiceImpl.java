package com.peso.elBuenSabor.services;

import com.peso.elBuenSabor.entities.Factura;
import com.peso.elBuenSabor.repositories.BaseRepository;
import com.peso.elBuenSabor.repositories.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FacturaServiceImpl extends BaseServiceImpl<Factura, Long> implements FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    public FacturaServiceImpl(BaseRepository<Factura, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Factura> findFacturasByFechaBetween(Date fechaInicio, Date fechaFin) {
        List<Factura> facturas = facturaRepository.findFacturasByFechaBetween(fechaInicio, fechaFin);
        return facturas;
    }
}
