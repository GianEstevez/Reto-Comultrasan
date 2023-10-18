package com.reto.backend.models;

import jakarta.persistence.*;

@Table(name = "USUARIOS")
@Entity
public class Usuario {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String primerNombre;

    @Column
    private String segundoNombre;

    @Column
    private String primerApellido;

    @Column
    private String segundoApellido;

    @Column
    private String numeroTelefono;

    @Column
    private String correo;
}
