package com.reto.backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * DTO for {@link com.reto.backend.models.Producto}
 */
// @AllArgsConstructor
// @Getter
public record ProductoDTO(String tipo_cuenta, String numero_cuenta, Double saldo) implements Serializable {
}