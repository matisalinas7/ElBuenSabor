package com.peso.elBuenSabor.controllers;

import com.peso.elBuenSabor.entities.DetalleArticuloManufacturado;
import com.peso.elBuenSabor.repositories.DetalleArticuloManufacturadoRepository;
import com.peso.elBuenSabor.services.DetalleArticuloManufacturadoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "elbuensabor/v1/detalleartmanuf")
public class DetalleArticuloManufacturadoController extends BaseControllerImpl<DetalleArticuloManufacturado, DetalleArticuloManufacturadoServiceImpl> {


}
