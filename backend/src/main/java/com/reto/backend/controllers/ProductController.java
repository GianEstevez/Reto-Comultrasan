package com.reto.backend.controllers;

import com.reto.backend.dtos.EnlaceDTO;
import com.reto.backend.dtos.EnlacesProductoDTO;
import com.reto.backend.dtos.ProductosUsuarioDTO;
import com.reto.backend.services.ProductService;
import com.reto.backend.services.TestDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    TestDataService testDataService;

    @GetMapping
    public ResponseEntity<ProductosUsuarioDTO> getProductos(@RequestParam("idUsuario") Long userId){

        // Return 200 OK
        return ResponseEntity.ok(productService.getProductosFromIdUsuario(userId));
    }

    @GetMapping("enlacesPago")
    public ResponseEntity<EnlacesProductoDTO> getEnlacesPago(@RequestParam("codigoProducto") String codigoProducto){

        // Return 200 OK
        return ResponseEntity.ok(productService.getEnlacesPagoFromCodigoProducto(codigoProducto));
    }

    @GetMapping("createTestData")
    public ResponseEntity<String> createTestData(){

        testDataService.initializeTestData();

        // Return 200 OK
        return ResponseEntity.ok("Datos creados!");
    }
}
