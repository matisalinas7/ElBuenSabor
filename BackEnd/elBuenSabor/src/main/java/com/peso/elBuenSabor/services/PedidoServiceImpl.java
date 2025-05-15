package com.peso.elBuenSabor.services;

import com.peso.elBuenSabor.entities.Pedido;
import com.peso.elBuenSabor.repositories.BaseRepository;
import com.peso.elBuenSabor.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl extends BaseServiceImpl<Pedido, Long> implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public PedidoServiceImpl(BaseRepository<Pedido, Long> baseRepository) {
        super(baseRepository);
    }
    @Override
    public List<Pedido> findPedidosBycliente_id(Long cliente_id){
        return pedidoRepository.findBycliente_id(cliente_id);
    }

}
