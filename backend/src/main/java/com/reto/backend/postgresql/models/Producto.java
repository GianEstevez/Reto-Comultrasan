package com.reto.backend.postgresql.models;

import com.reto.backend.postgresql.repositories.ProductoRepository;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "PRODUCTOS")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="id_usuario", nullable = false)
    private Usuario usuario;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String codigo;

    @Transient
    private Double saldo;

    public void updateSaldo(ProductoRepository productoRepository) {
        // Use the repository to calculate the saldo
        Double calculatedSaldo = productoRepository.calculateSaldo(this);

        // Set the calculated saldo to the saldo field
        this.saldo = calculatedSaldo != null ? calculatedSaldo : 0;
    }

}
