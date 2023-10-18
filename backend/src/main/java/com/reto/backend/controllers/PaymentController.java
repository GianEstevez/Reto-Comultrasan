package com.reto.backend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/template")
public class PaymentController {

    @GetMapping("payment")
    public ResponseEntity<String> getPlantillaPago(){

        return null;
    }
}
