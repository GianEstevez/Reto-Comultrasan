package com.reto.backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * DTO for {@link com.reto.backend.models.Producto}
 */
@AllArgsConstructor
@Getter
public record ProductoDto(String nombre, String codigo, Double saldo) implements Serializable {
}