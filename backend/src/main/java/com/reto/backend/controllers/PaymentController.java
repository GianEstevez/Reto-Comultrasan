package com.reto.backend.controllers;

import com.reto.backend.mongodb.models.PlantillaEnlacePago;
import com.reto.backend.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/template")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping("payment")
    public ResponseEntity<PlantillaEnlacePago> getPlantillaEnlacePago(@RequestParam String codigo){
        PlantillaEnlacePago plantillaEnlacePago = paymentService.getPlantillaEnlaceByCodigo(codigo);
        return ResponseEntity.ok(plantillaEnlacePago);
    }
}
