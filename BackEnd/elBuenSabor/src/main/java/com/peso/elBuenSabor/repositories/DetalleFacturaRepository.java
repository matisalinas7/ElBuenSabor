package com.peso.elBuenSabor.repositories;

import com.peso.elBuenSabor.entities.DetalleFactura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleFacturaRepository extends BaseRepository<DetalleFactura, Long> {
}
