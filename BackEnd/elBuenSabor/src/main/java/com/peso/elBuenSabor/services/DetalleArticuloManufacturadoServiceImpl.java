package com.peso.elBuenSabor.services;


import com.peso.elBuenSabor.entities.DetalleArticuloManufacturado;
import com.peso.elBuenSabor.repositories.BaseRepository;
import com.peso.elBuenSabor.repositories.DetalleArticuloManufacturadoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


@Service
public class DetalleArticuloManufacturadoServiceImpl extends BaseServiceImpl<DetalleArticuloManufacturado, Long> implements DetalleArticuloManufacturadoService {

    @Autowired
    private DetalleArticuloManufacturadoRepository detalleArticuloManufacturadoRepository;

    public DetalleArticuloManufacturadoServiceImpl(BaseRepository<DetalleArticuloManufacturado, Long> baseRepository) {
        super(baseRepository);
    }


}
