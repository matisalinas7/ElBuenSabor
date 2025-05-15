package com.peso.elBuenSabor.controllers;

import com.peso.elBuenSabor.entities.DetalleFactura;
import com.peso.elBuenSabor.services.DetalleFacturaServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "elbuensabor/v1/detallefacturas")
public class DetalleFacturaController extends BaseControllerImpl<DetalleFactura, DetalleFacturaServiceImpl> {

}
