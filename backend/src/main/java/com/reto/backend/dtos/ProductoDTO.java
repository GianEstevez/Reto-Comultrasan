package com.reto.backend.dtos;

import com.reto.backend.postgresql.models.Producto;

import java.io.Serializable;

/**
 * DTO for {@link Producto}
 */
// @AllArgsConstructor
// @Getter
public record ProductoDTO(String tipo_cuenta, String numero_cuenta, Double saldo) implements Serializable {
}