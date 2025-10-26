package com.peso.elBuenSabor.controllers;

import com.peso.elBuenSabor.entities.ArticuloInsumo;
import com.peso.elBuenSabor.services.ArticuloInsumoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "elbuensabor/v1/articulosinsumo")
public class ArticuloInsumoController extends BaseControllerImpl<ArticuloInsumo, ArticuloInsumoServiceImpl> {

//  Historia usuario #25 - Control de stock de ingredientes

    @GetMapping("/bajostockminimo")
    public ResponseEntity<List<ArticuloInsumo>> getArticulosInsumoStockActualBajoStockMinimo() {
        List<ArticuloInsumo> result = servicio.findArticuloInsumoByStockActualBajoStockMinimo();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/cercastockminimo")
    public ResponseEntity<?> getArticulosInsumoStockActualCercaStockMinimo(
            @RequestParam(defaultValue = "0.2") Double margen) {
        try {
            return ResponseEntity.ok(servicio.findArticuloInsumoByStockActualCercaStockMinimo(margen));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"Error\":\"Error, por favor, intente mas tarde\"}");
        }
    }



}
