package com.reto.backend.controllers;

import com.reto.backend.dtos.LoginDTO;
import com.reto.backend.dtos.ProductosUsuarioDTO;
import com.reto.backend.services.ProductService;
import com.reto.backend.services.TestDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/authorization")
public class AuthorizationController {

    @Autowired
    ProductService productService;

    @Autowired
    TestDataService testDataService;

    @GetMapping("login")
    public ResponseEntity<ProductosUsuarioDTO> getProductos(@RequestBody LoginDTO loginDTO){

        // Return 200 OK
        // return ResponseEntity.ok(productService.getProductosFromIdUsuario(userId));

        return null;
    }

}
