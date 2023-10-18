package com.reto.backend.services;

import com.reto.backend.dtos.ProductoDTO;
import com.reto.backend.models.Producto;
import com.reto.backend.models.Usuario;
import com.reto.backend.repositories.ProductoRepository;
import com.reto.backend.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    ProductoRepository productoRepository;

    public List<ProductoDTO> getProductosFromIdUsuario(Long idUsuario){
        Usuario usuario = usuarioRepository.getReferenceById(idUsuario);
        List<Producto> productos = productoRepository.getProductosByUsuario(usuario);

        // Actualizar saldo para cada producto
        for (Producto producto : productos) {
            producto.updateSaldo(productoRepository);
        }

        return productos.stream().map(p -> new ProductoDTO(p.getNombre(), p.getCodigo(), p.getSaldo())).toList();

    }
}
