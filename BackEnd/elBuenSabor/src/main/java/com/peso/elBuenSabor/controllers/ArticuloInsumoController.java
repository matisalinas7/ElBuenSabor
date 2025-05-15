package com.peso.elBuenSabor.controllers;

import com.peso.elBuenSabor.entities.ArticuloInsumo;
import com.peso.elBuenSabor.services.ArticuloInsumoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "elbuensabor/v1/articulosinsumo")
public class ArticuloInsumoController extends BaseControllerImpl<ArticuloInsumo, ArticuloInsumoServiceImpl> {

//  Historia usuario #25 - Control de stock de ingredientes

    @GetMapping("/bajostockminimo")
    public ResponseEntity<?> getArticulosInsumoStockActualBajoStockMinimo() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findArticuloInsumoByStockActualBajoStockMinimo());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Error, por favor, intente mas tarde\"}");
        }
    }
    @GetMapping("/cercastockminimo")
    public ResponseEntity<?> getArticulosInsumoStockActualCercaStockMinimo() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findArticuloInsumoByStockActualCercaStockMinimo());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Error, por favor, intente mas tarde\"}");
        }
    }
//

}
