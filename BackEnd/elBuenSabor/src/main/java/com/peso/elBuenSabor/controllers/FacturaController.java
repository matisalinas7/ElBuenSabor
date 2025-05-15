package com.peso.elBuenSabor.controllers;

import com.peso.elBuenSabor.entities.Factura;
import com.peso.elBuenSabor.services.FacturaService;
import com.peso.elBuenSabor.services.FacturaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "elbuensabor/v1/facturas")
public class FacturaController extends BaseControllerImpl<Factura, FacturaServiceImpl> {
    @Autowired
    private FacturaService facturaService;

    @GetMapping("/informe-movimientos-monetarios")
    public ResponseEntity<Map<String, Double>> obtenerInformeMovimientosMonetarios(@RequestParam String fechaInicio, @RequestParam String fechaFin) {
        Date fechaInicioDate = parsearFecha(fechaInicio);
        Date fechaFinDate = parsearFecha(fechaFin);

        List<Factura> facturas = facturaService.findFacturasByFechaBetween(fechaInicioDate, fechaFinDate);
        Map<String, Double> informe = calcularInformeMonetario(facturas);

        return new ResponseEntity<>(informe, HttpStatus.OK);
    }

    private Date parsearFecha(String fecha) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.parse(fecha);
        } catch (ParseException e) {
            // Manejar la excepción o devolver una fecha por defecto en caso de error.
            e.printStackTrace();
            return new Date(); // Fecha por defecto
        }
        // Implementa la lógica para parsear la fecha desde una cadena en el formato adecuado.
        // Puedes utilizar bibliotecas como SimpleDateFormat o LocalDate para realizar esta conversión.
    }

    private Map<String, Double> calcularInformeMonetario(List<Factura> facturas) {
        Map<String, Double> informe = new HashMap<>();

        double ingresos = 0.0;
        double costos = 0.0;

        for (Factura factura : facturas) {
            ingresos = factura.getTotalVenta(); // Suponiendo que el monto está en la factura
            // Puedes agregar lógica adicional para calcular costos si es necesario
        }

        double ganancias = ingresos - costos;

        informe.put("ingresos", ingresos);
        informe.put("costos", costos);
        informe.put("ganancias", ganancias);

        return informe;
    }



}
