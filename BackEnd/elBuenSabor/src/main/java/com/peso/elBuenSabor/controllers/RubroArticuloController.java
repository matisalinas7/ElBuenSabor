package com.peso.elBuenSabor.controllers;

import com.peso.elBuenSabor.entities.RubroArticulo;
import com.peso.elBuenSabor.services.RubroArticuloServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "elbuensabor/v1/rubroarticulos")
public class RubroArticuloController extends BaseControllerImpl<RubroArticulo, RubroArticuloServiceImpl> {


}
