package com.peso.elBuenSabor.repositories;

import com.peso.elBuenSabor.entities.Cliente;
import com.peso.elBuenSabor.entities.DetalleArticuloManufacturado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DetalleArticuloManufacturadoRepository extends BaseRepository<DetalleArticuloManufacturado, Long> {

}
