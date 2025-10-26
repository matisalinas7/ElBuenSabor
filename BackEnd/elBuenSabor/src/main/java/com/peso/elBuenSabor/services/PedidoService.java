package com.peso.elBuenSabor.services;

import com.peso.elBuenSabor.entities.Pedido;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface PedidoService extends BaseService<Pedido, Long> {

    List<Pedido> findPedidosByClienteId(Long cliente_id);

}
