package com.reto.backend.dtos;

import java.util.List;

public record ProductosUsuarioDTO(Long idUsuario, String nombreUsuario, List<ProductoDTO> productos) {
}
