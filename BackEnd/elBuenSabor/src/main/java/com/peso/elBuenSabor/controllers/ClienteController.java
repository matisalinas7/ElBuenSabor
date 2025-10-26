package com.peso.elBuenSabor.controllers;

import com.peso.elBuenSabor.entities.Cliente;
import com.peso.elBuenSabor.services.ClienteService;
import com.peso.elBuenSabor.services.ClienteServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "elbuensabor/v1/clientes")
public class ClienteController extends BaseControllerImpl<Cliente, ClienteService> {
    //private String filtro;

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String filtro){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"Error\":\"Error, por favor, intente mas tarde\"}"));
        }
    }
    @GetMapping("/searchPaged")
    public ResponseEntity<?> search(@RequestParam String filtro , Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro , pageable));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"Error\":\"Error, por favor, intente mas tarde\"}"));
        }
    }

}
