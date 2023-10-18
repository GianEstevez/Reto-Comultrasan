package com.reto.backend.dtos;

import java.io.Serializable;
import java.time.Instant;

public record TransaccionEnlaceDTO(Instant fechaHora, Double monto, String descripcion) implements Serializable {
}
