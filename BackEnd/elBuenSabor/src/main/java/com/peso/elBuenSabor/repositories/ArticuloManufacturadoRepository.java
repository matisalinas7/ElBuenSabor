package com.peso.elBuenSabor.repositories;

import com.peso.elBuenSabor.entities.ArticuloManufacturado;
import com.peso.elBuenSabor.entities.Cliente;
import com.peso.elBuenSabor.entities.DetalleArticuloManufacturado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Repository
public interface ArticuloManufacturadoRepository extends BaseRepository<ArticuloManufacturado, Long> {

    // Historia de Usuarion #26 - Ranking de Productos
    @Query("SELECT am.id  , am.nombre , COALESCE(SUM(dp.cantidad ), 0) AS Cantidad_Total " +
            "FROM ArticuloManufacturado am LEFT JOIN DetallePedido dp on dp.articuloManufacturado.id = am.id  " +
            "GROUP BY am.id , am.nombre ORDER BY COALESCE(SUM(dp.cantidad), 0) DESC")
    List<Object[]> findTopSellingProducts();

    @Query("SELECT am.id  , am.nombre , COALESCE(SUM(dp.cantidad ), 0) AS Cantidad_Total " +
            "FROM ArticuloManufacturado am LEFT JOIN DetallePedido dp on dp.articuloManufacturado.id = am.id  " +
            "WHERE dp.pedido.fechaPedido BETWEEN :fechaIn AND :fechaFin " +
            "GROUP BY am.id , am.nombre ORDER BY COALESCE(SUM(dp.cantidad), 0) DESC")
    List<Object[]> findTopSellingProductsByFecha(
            @Param("fechaIn") Date fechaIn,
            @Param("fechaFin") Date fechaFin
    );


    // Búsqueda normal
    List<ArticuloManufacturado> findByDenominacion(String denominacion);

    // Búsqueda paginada
    Page<ArticuloManufacturado> findByDenominacion(String denominacion, Pageable pageable);

    // Anotacion JPQL parametros indexados (Buscar artículos manufacturados con un precio de venta mayor que cierto valor)
    @Query("SELECT am FROM ArticuloManufacturado am WHERE am.precioVenta > :precio")
    List<ArticuloManufacturado> findArticulosConPrecioMayorQue(@Param("precio")BigDecimal precio);

    @Query("SELECT am FROM ArticuloManufacturado am WHERE am.precioVenta > :precio")
    List<ArticuloManufacturado> findArticulosConPrecioMayorQue(@Param("precio")BigDecimal precio, Pageable pageable);



    // (Buscar articulos manufacturados por tiempo estimado de cocina)
    @Query("SELECT am FROM ArticuloManufacturado am WHERE am.tiempoEstimadoCocina = :tiempo")
    List<ArticuloManufacturado> findArticulosPorTiempoEstimadoCocina(@Param("tiempo") Integer tiempo);

    @Query("SELECT am FROM ArticuloManufacturado am WHERE am.tiempoEstimadoCocina = :tiempo")
    List<ArticuloManufacturado> findArticulosPorTiempoEstimadoCocina(@Param("tiempo") Integer tiempo, Pageable pageable);

    @Query(value = "SELECT * FROM articulo_manufacturado WHERE denominacion LIKE %:filtro%", nativeQuery = true)
    List<ArticuloManufacturado> searchNativo(@Param("filtro") String filtro);

    @Query(value = "SELECT * FROM articulo_manufacturado WHERE denominacion LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM articulo_manufacturado",
            nativeQuery = true)
    Page<ArticuloManufacturado> searchNativo(@Param("filtro") String filtro, Pageable pageable);

}
