package com.reto.backend.services;


import java.time.Instant;

import com.reto.backend.models.EnlacePago;
import com.reto.backend.models.Producto;
import com.reto.backend.models.Transaccion;
import com.reto.backend.models.TransaccionEnlace;
import com.reto.backend.repositories.EnlacePagoRepository;
import com.reto.backend.repositories.ProductoRepository;
import com.reto.backend.repositories.TransaccionEnlaceRepository;
import com.reto.backend.repositories.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestDataInitializacionService {

    @Autowired
    private EnlacePagoRepository enlacePagoRepository;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private TransaccionRepository transaccionRepository;
    @Autowired
    private TransaccionEnlaceRepository transaccionEnlaceRepository;

    public void initializeTestData() {
        // Crear tres productos de ejemplo
        Producto producto1 = createProducto("Producto 1", "COD1");
        Producto producto2 = createProducto("Producto 2", "COD2");
        Producto producto3 = createProducto("Producto 3", "COD3");

        // Crear enlaces de pago
        EnlacePago enlace1 = createEnlacePago(producto1, Instant.now(), Instant.now().plusSeconds(3600));
        EnlacePago enlace2 = createEnlacePago(producto2, Instant.now(), Instant.now().plusSeconds(3600));
        EnlacePago enlace3 = createEnlacePago(producto3, Instant.now(), Instant.now().plusSeconds(3600));

        // Crear transacciones y enlaces a los enlaces de pago
        Transaccion transaccion1 = createTransaccion(producto1, 100.0);
        TransaccionEnlace transaccionEnlace1 = createTransaccionEnlace(enlace1, transaccion1, "192.168.1.1", Instant.now(), "fingerprint1");

        Transaccion transaccion2 = createTransaccion(producto2, 200.0);
        TransaccionEnlace transaccionEnlace2 = createTransaccionEnlace(enlace2, transaccion2, "192.168.1.2", Instant.now(), "fingerprint2");

        Transaccion transaccion3 = createTransaccion(producto3, 150.0);
        TransaccionEnlace transaccionEnlace3 = createTransaccionEnlace(enlace3, transaccion3, "192.168.1.3", Instant.now(), "fingerprint3");
    }

    private Producto createProducto(String nombre, String codigo) {
        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setCodigo(codigo);
        productoRepository.save(producto);
        return producto;
    }

    private EnlacePago createEnlacePago(Producto producto, Instant fechaHoraDesde, Instant fechaHoraHasta) {
        EnlacePago enlacePago = new EnlacePago();
        enlacePago.setProducto(producto);
        enlacePago.setFechaHoraDesde(fechaHoraDesde);
        enlacePago.setFechaHoraHasta(fechaHoraHasta);
        enlacePagoRepository.save(enlacePago);
        return enlacePago;
    }

    private Transaccion createTransaccion(Producto producto, Double valor) {
        Transaccion transaccion = new Transaccion();
        transaccion.setProducto(producto);
        transaccion.setValor(valor);
        transaccionRepository.save(transaccion);
        return transaccion;
    }

    private TransaccionEnlace createTransaccionEnlace(EnlacePago enlacePago, Transaccion transaccion, String ip,
                                                      Instant fechaHora, String huella) {
        TransaccionEnlace transaccionEnlace = new TransaccionEnlace();
        transaccionEnlace.setEnlacePago(enlacePago);
        transaccionEnlace.setTransaccion(transaccion);
        transaccionEnlace.setIp(ip);
        transaccionEnlace.setFechaHora(fechaHora);
        transaccionEnlace.setHuella(huella);
        transaccionEnlaceRepository.save(transaccionEnlace);
        return transaccionEnlace;
    }
}
