package com.reto.backend.postgresql.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "TRANSACCIONES")
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String codigo;

    @ManyToOne
    @JoinColumn(name="id_producto")
    private Producto producto;

    @Column(nullable = false)
    private Double valor;

    @Column(nullable = false)
    private Boolean exitosa;

    @Column(nullable = false)
    private Instant fechaHora = Instant.now();
}