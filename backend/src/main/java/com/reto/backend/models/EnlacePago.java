package com.reto.backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "ENLACES_PAGO")
public class EnlacePago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String codigo;

    @Column(nullable = false)
    private String url;

    @ManyToOne
    @JoinColumn(name="id_producto", nullable = false)
    private Producto producto;

    @Column(nullable = false)
    private Instant fechaHoraDesde = Instant.now();

    @Column
    private Instant fechaHoraHasta;

    @Column(columnDefinition = "boolean default true", nullable = false)
    private Boolean activo;
}