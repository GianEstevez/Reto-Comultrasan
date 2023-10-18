package com.reto.backend.controllers;

import com.reto.backend.mongodb.models.Comprobante;
import com.reto.backend.mongodb.models.PlantillaEnlacePago;
import com.reto.backend.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pagos")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping
    public ResponseEntity<PlantillaEnlacePago> getPlantillaEnlacePago(@RequestParam String codigo){
        PlantillaEnlacePago plantillaEnlacePago = paymentService.getPlantillaEnlaceByCodigo(codigo);
        return ResponseEntity.ok(plantillaEnlacePago);
    }

    @GetMapping("enlace")
    public ResponseEntity<List<Comprobante>> getTransaccionesEnlace(@RequestParam String codigoEnlace){

        List<Comprobante> comprobantes = paymentService.getTransaccionesEnlaceByCodigo(codigoEnlace);
        return ResponseEntity.ok(comprobantes);
    }

    @GetMapping("comprobante")
    public ResponseEntity<Comprobante> getComprobante(@RequestParam String codigoTransaccion){

        Comprobante comprobante = paymentService.getComprobanteByCodigoTransaccion(codigoTransaccion);
        return ResponseEntity.ok(comprobante);
    }
}
