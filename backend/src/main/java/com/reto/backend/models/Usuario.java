package com.reto.backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "USUARIOS")
public class Persona {

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
