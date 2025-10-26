package com.peso.elBuenSabor.controllers;

import com.peso.elBuenSabor.DTOs.DTORankingProducto;
import com.peso.elBuenSabor.entities.ArticuloManufacturado;
import com.peso.elBuenSabor.services.ArticuloManufacturadoServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "elbuensabor/v1/articulosmanufacturados")
public class ArticuloManufacturadoController extends BaseControllerImpl<ArticuloManufacturado, ArticuloManufacturadoServiceImpl> {

    // 🔹 Versión sin paginación (trae todo)
    @GetMapping("/denominacion")
    public ResponseEntity<?> getArticulosByDenominacion(@RequestParam String denominacion) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findByDenominacion(denominacion));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Error, por favor, intente mas tarde\"}");
        }
    }

    // 🔹 Versión paginada
    @GetMapping("/denominacion/page")
    public ResponseEntity<?> getArticulosByDenominacionPageable(
            @RequestParam String denominacion,
            Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findByDenominacion(denominacion, pageable));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Error, por favor, intente mas tarde\"}");
        }
    }


    @GetMapping("/precioMayor")
    public ResponseEntity<?> getArticulosConPrecioMayorQue(@RequestParam BigDecimal precio) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findArticulosConPrecioMayorQue(precio));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Error, por favor, intente mas tarde\"}");
        }
    }

    @GetMapping("/ranking")
    public ResponseEntity<?> findTopSellingProducts() {
        try {
            List<DTORankingProducto> ranking = servicio.findTopSellingProducts();
            return ResponseEntity.ok(ranking);
        } catch (Exception e) {

            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"Error\":\"Error, por favor, intente mas tarde\"}");
        }
    }

    @GetMapping("/rankingFechas")
    public ResponseEntity<?> findTopSellingProductsByFecha (
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaIn,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFin
    ){
        try {
            List<DTORankingProducto> ranking = servicio.findTopSellingProductsByFecha(fechaIn, fechaFin);
            return ResponseEntity.ok(ranking);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"Error\":\"Error, por favor, intente mas tarde\"}");
        }
    }
}
