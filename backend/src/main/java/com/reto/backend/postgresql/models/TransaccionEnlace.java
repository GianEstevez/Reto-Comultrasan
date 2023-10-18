package com.reto.backend.postgresql.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TRANSACCIONES_ENLACE")
public class TransaccionEnlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="id_enlace", nullable = false)
    private EnlacePago enlacePago;

    @ManyToOne
    @JoinColumn(name="id_transaccion", nullable = false)
    private Transaccion transaccion;

    @Column(nullable = false)
    private String ip;

    @Column(nullable = false)
    private String huella;

}
