package com.peso.elBuenSabor.repositories;

import com.peso.elBuenSabor.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends BaseRepository<Pedido, Long> {

    // JPQL parametros indexados
    @Query(value = "SELECT p FROM Pedido p WHERE p.cliente.id = :cliente_id")
    List<Pedido> findBycliente_id(@Param("cliente_id") Long cliente_id);
}
