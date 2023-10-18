package com.reto.backend.dtos;

import java.io.Serializable;
import java.util.List;

public record EnlacesProductoDTO(Long limite, List<EnlaceDTO> enlaces) implements Serializable {
}
