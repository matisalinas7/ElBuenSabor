package com.peso.elBuenSabor.repositories;

import com.peso.elBuenSabor.entities.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallePedidoRepository extends BaseRepository<DetallePedido, Long> {
}
