package com.peso.elBuenSabor.repositories;

import com.peso.elBuenSabor.entities.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends BaseRepository<Cliente, Long> {

    List<Cliente> findByNombreContainingOrApellidoContaining(String nombre, String apellido);
    Page<Cliente> findByNombreContainingOrApellidoContaining(String nombre, String apellido , Pageable pageable);

    //Anotacion JPQL parametros indexados

    @Query(value = "SELECT p FROM Cliente p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%")
    List<Cliente> search(@Param("filtro") String filtro);
    @Query(value = "SELECT p FROM Cliente p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%")
    Page<Cliente> search(@Param("filtro") String filtro , Pageable pageable);

    @Query(value = "SELECT * FROM Cliente WHERE Cliente.nombre LIKE %:filtro% OR Cliente.apellido LIKE %:filtro%",
            nativeQuery = true)
    List<Cliente> searchNativo(@Param("filtro") String filtro);

    @Query(value = "SELECT * FROM Cliente WHERE Cliente.nombre LIKE %:filtro% OR Cliente.apellido LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM Cliente",
            nativeQuery = true)
    Page<Cliente> searchNativo(@Param("filtro") String filtro, Pageable pageable);

}
