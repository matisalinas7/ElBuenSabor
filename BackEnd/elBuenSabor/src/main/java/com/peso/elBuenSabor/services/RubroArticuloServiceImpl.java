package com.peso.elBuenSabor.services;

import com.peso.elBuenSabor.entities.RubroArticulo;
import com.peso.elBuenSabor.repositories.BaseRepository;
import com.peso.elBuenSabor.repositories.RubroArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RubroArticuloServiceImpl extends BaseServiceImpl<RubroArticulo, Long> implements RubroArticuloService {

    @Autowired
    private RubroArticuloRepository rubroArticuloRepository;

    public RubroArticuloServiceImpl(BaseRepository<RubroArticulo, Long> baseRepository) {
        super(baseRepository);
    }
}
