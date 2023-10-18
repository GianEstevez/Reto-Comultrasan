package com.reto.backend.controllers;

import com.reto.backend.dtos.ProductoDTO;
import com.reto.backend.dtos.UserDataDTO;
import com.reto.backend.services.ProductService;
import com.reto.backend.services.TestDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    TestDataService testDataService;

    @GetMapping
    public ResponseEntity<List<ProductoDTO>> generateHTML(@RequestBody UserDataDTO userDataDTO){

        // Return 200 OK
        return ResponseEntity.ok(productService.getProductosFromIdUsuario(userDataDTO.userId()));
    }

    @GetMapping("createTestData")
    public ResponseEntity<String> generateHTML(){

        testDataService.initializeTestData();

        // Return 200 OK
        return ResponseEntity.ok("Datos creados!");
    }
}
