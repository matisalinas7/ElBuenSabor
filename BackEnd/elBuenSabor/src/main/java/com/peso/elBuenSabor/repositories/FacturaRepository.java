package com.peso.elBuenSabor.repositories;

import com.peso.elBuenSabor.entities.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FacturaRepository extends BaseRepository<Factura, Long> {

    @Query("SELECT f FROM Factura f WHERE f.fechaFacturacion BETWEEN :fechaInicio AND :fechaFin")
    List<Factura> findFacturasByFechaBetween(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);

}
