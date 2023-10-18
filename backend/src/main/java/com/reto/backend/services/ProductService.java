package com.reto.backend.services;

import com.reto.backend.dtos.EnlaceDTO;
import com.reto.backend.dtos.ProductoDTO;
import com.reto.backend.dtos.ProductosUsuarioDTO;
import com.reto.backend.postgresql.models.EnlacePago;
import com.reto.backend.postgresql.models.Producto;
import com.reto.backend.postgresql.models.Usuario;
import com.reto.backend.postgresql.repositories.EnlacePagoRepository;
import com.reto.backend.postgresql.repositories.ProductoRepository;
import com.reto.backend.postgresql.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    ProductoRepository productoRepository;

    @Autowired
    EnlacePagoRepository enlacePagoRepository;

    public ProductosUsuarioDTO getProductosFromIdUsuario(Long idUsuario){
        Usuario usuario = usuarioRepository.getReferenceById(idUsuario);
        List<Producto> productos = productoRepository.getProductosByUsuario(usuario);

        // Actualizar saldo para cada producto
        for (Producto producto : productos) {
            producto.updateSaldo(productoRepository);
        }

        List<ProductoDTO> productosDTO =  productos.stream().map(p -> new ProductoDTO(p.getNombre(), p.getCodigo(), p.getSaldo())).toList();

        return new ProductosUsuarioDTO(idUsuario, usuario.getPrimerNombre(), productosDTO);

    }

    public List<EnlaceDTO> getEnlacesPagoFromCodigoProducto(String codigoProducto){
        Producto producto = productoRepository.getProductoByCodigo(codigoProducto);
        List<EnlacePago> enlacesPago = enlacePagoRepository.getEnlacePagosByProducto(producto);

        return enlacesPago.stream().map(ep -> new EnlaceDTO(ep.getCodigo(), ep.getNombre(), ep.getUrl())).toList();
    }
}
