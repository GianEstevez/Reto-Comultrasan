package com.reto.backend.postgresql.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "USUARIOS")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String primerNombre;

    @Column
    private String segundoNombre;

    @Column(nullable = false)
    private String primerApellido;

    @Column
    private String segundoApellido;

    @Column(nullable = false)
    private String numeroTelefono;

    @Column(nullable = false)
    private String correo;

    @Column(nullable = false)
    private Long limiteEnlacesPago;
}
