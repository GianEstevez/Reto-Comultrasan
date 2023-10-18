package com.reto.backend.controllers;

import com.reto.backend.dtos.UserData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @GetMapping("/html")
    public ResponseEntity<String> generateHTML(@RequestBody UserData userData){

        // Return 200 OK
        return ResponseEntity.ok("Hola!");
    }
}
