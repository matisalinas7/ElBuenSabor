package com.peso.elBuenSabor.controllers;

import com.peso.elBuenSabor.entities.DetallePedido;
import com.peso.elBuenSabor.services.DetallePedidoService;
import com.peso.elBuenSabor.services.DetallePedidoServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "elbuensabor/v1/detallepedidos")
public class DetallePedidoController extends BaseControllerImpl<DetallePedido, DetallePedidoService> {

}
