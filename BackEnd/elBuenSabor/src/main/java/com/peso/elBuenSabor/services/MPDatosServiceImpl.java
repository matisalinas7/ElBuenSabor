package com.peso.elBuenSabor.services;

import com.peso.elBuenSabor.entities.MPDatos;
import com.peso.elBuenSabor.repositories.BaseRepository;
import com.peso.elBuenSabor.repositories.MPDatosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MPDatosServiceImpl extends BaseServiceImpl<MPDatos, Long> implements MPDatosService {

    @Autowired
    private MPDatosRepository mpDatosRepository;

    public MPDatosServiceImpl(BaseRepository<MPDatos, Long> baseRepository) {
        super(baseRepository);
    }
}
