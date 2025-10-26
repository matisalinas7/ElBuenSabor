package com.peso.elBuenSabor.controllers;

import com.peso.elBuenSabor.entities.Pedido;
import com.peso.elBuenSabor.services.PedidoService;
import com.peso.elBuenSabor.services.PedidoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.events.Event;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "elbuensabor/v1/pedidos")
public class PedidoController extends BaseControllerImpl<Pedido, PedidoService> {

    @GetMapping("/cliente/{clienteId}")
        public List<Pedido> getPedidosByClienteId(@PathVariable Long clienteId) {
            return servicio.findPedidosByClienteId(clienteId);
        }

}





