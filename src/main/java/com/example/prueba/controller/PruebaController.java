package com.example.prueba.controller;

import com.example.prueba.entity.Prueba1;
import com.example.prueba.service.PruebaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PruebaController {

    @Autowired
    PruebaServiceImpl pruebaService;

    @GetMapping("/verDatosAgrupados")
    public ResponseEntity<?> verDatosAgrupados(){

        Map<Object, List<Prueba1>> response = new HashMap<>();

        try {
            response = pruebaService.getDatosAgrupadosPorEdad();
            return ResponseEntity.ok( response );
        } catch (Exception ex ){
            System.out.println("Ha ocurrido un error...");
        }

        return ResponseEntity.internalServerError().build();
    }

    @GetMapping("/ordernadosAlfabeticamente")
    public ResponseEntity<?> ordernadosAlfabeticamente(){

        Map<Object, List<Prueba1>> response = new HashMap<>();

        try {
            response = pruebaService.ordernadosAlfabeticamente();
            return ResponseEntity.ok( response );
        } catch (Exception ex ){
            System.out.println("Ha ocurrido un error...");
        }

        return ResponseEntity.internalServerError().build();
    }

}
