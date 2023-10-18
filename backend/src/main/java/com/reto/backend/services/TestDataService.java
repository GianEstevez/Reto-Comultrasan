package com.reto.backend.services;


import java.time.Instant;

import com.reto.backend.postgresql.models.*;
import com.reto.backend.postgresql.repositories.*;
import com.reto.backend.utils.RandomGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestDataService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private EnlacePagoRepository enlacePagoRepository;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private TransaccionRepository transaccionRepository;
    @Autowired
    private TransaccionEnlaceRepository transaccionEnlaceRepository;

    public void initializeTestData() {

        Usuario yuri = usuarioRepository.getReferenceById(1L);
        Usuario edward = usuarioRepository.getReferenceById(2L);
        Usuario gian = usuarioRepository.getReferenceById(3L);

        // Crear tres productos de ejemplo
        Producto producto1 = createProducto("Cuenta de Ahorros", "COD1", yuri);
        Producto producto2 = createProducto("Cuenta de Ahorros Amiga", "COD2", edward);
        Producto producto3 = createProducto("Cuenta de Ahorros Enemiga", "COD3", edward);
        Producto producto4 = createProducto("Cuenta de Ahorros de Broma", "COD4", gian);

        // Crear enlaces de pago
        EnlacePago enlace1 = createEnlacePago(producto2, Instant.now(), Instant.now().plusSeconds(3600));
        EnlacePago enlace2 = createEnlacePago(producto3, Instant.now(), Instant.now().plusSeconds(36000));
        EnlacePago enlace3 = createEnlacePago(producto4, Instant.now(), Instant.now().plusSeconds(360000));

        // Crear transacciones y enlaces a los enlaces de pago
        Transaccion transaccion1 = createTransaccion(producto1, 10000d);
        createTransaccionEnlace(enlace1, transaccion1, "192.168.1.1", "fingerprint1");

        Transaccion transaccion2 = createTransaccion(producto2, 900000d);
        createTransaccionEnlace(enlace2, transaccion2, "192.168.1.2", "fingerprint2");

        Transaccion transaccion3 = createTransaccion(producto3, 1000000d);
        createTransaccionEnlace(enlace3, transaccion3, "192.168.1.3", "fingerprint3");
    }

    private Producto createProducto(String nombre, String codigo, Usuario usuario) {
        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setCodigo(codigo);
        producto.setUsuario(usuario); // Set the Usuario for the Producto
        productoRepository.save(producto);
        return producto;
    }


    private EnlacePago createEnlacePago(Producto producto, Instant fechaHoraDesde, Instant fechaHoraHasta) {
        EnlacePago enlacePago = new EnlacePago();
        enlacePago.setProducto(producto);
        enlacePago.setCodigo(RandomGenerator.generateRandomString(6));
        enlacePago.setNombre("Enlace de pago" + RandomGenerator.generateRandomString(6));
        enlacePago.setFechaHoraDesde(fechaHoraDesde);
        enlacePago.setFechaHoraHasta(fechaHoraHasta);
        enlacePago.setActivo(true);
        enlacePago.setUrl("https://localhost:5000/pago/");
        enlacePagoRepository.save(enlacePago);
        return enlacePago;
    }

    private Transaccion createTransaccion(Producto producto, Double valor) {
        Transaccion transaccion = new Transaccion();
        transaccion.setProducto(producto);
        transaccion.setValor(valor);
        transaccion.setCodigo(RandomGenerator.generateRandomString(12));
        transaccionRepository.save(transaccion);
        return transaccion;
    }

    private void createTransaccionEnlace(EnlacePago enlacePago, Transaccion transaccion, String ip, String huella) {
        TransaccionEnlace transaccionEnlace = new TransaccionEnlace();
        transaccionEnlace.setEnlacePago(enlacePago);
        transaccionEnlace.setTransaccion(transaccion);
        transaccionEnlace.setIp(ip);
        transaccionEnlace.setHuella(huella);
        transaccionEnlaceRepository.save(transaccionEnlace);
    }
}
