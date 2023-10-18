package com.reto.backend.services;


import java.time.Instant;
import java.util.List;

import com.reto.backend.mongodb.models.CampoPlantilla;
import com.reto.backend.mongodb.models.Plantilla;
import com.reto.backend.mongodb.models.PlantillaEnlacePago;
import com.reto.backend.mongodb.repositories.PlantillaEnlacePagoRepository;
import com.reto.backend.mongodb.repositories.PlantillaRepository;
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
    @Autowired
    private PlantillaRepository plantillaRepository;
    @Autowired
    private PlantillaEnlacePagoRepository plantillaEnlacePagoRepository;


    public void initializeTestData() {
        CampoPlantilla campo1 = new CampoPlantilla("Descripcion", "[a-zA-Z\s]*", null);
        CampoPlantilla campo2 = new CampoPlantilla("Modelo de carro", "[a-zA-Z\s]*", "Mazda");
        CampoPlantilla campo3 = new CampoPlantilla("Numero de apartamento", "[0-9]+", null);

        Plantilla plantilla1 = createPlantilla("Tienda de bancos de sarmiendo angulo", "A1", List.of(campo2, campo1));
        Plantilla plantilla2 = createPlantilla("Pagos de arriendo", "B2", List.of(campo3, campo1));

        Usuario yuri = createUsuario("Yuri", "Prieto", "281828281", "yuri@yuri.com");
        Usuario edward = createUsuario("Edward", "Porodo", "322728281", "ed@yuri.com");
        Usuario gian = createUsuario("Gian", "Jean", "312728281", "gian@yuri.com");

        // Crear tres productos de ejemplo
        Producto producto1 = createProducto("Cuenta de Ahorros", "8717276663", yuri, 4L);
        Producto producto2 = createProducto("Cuenta de Ahorros Amiga", "98786262", edward, 0L);
        Producto producto3 = createProducto("Cuenta de Ahorros Enemiga", "9381112", edward, 4L);
        Producto producto4 = createProducto("Cuenta de Ahorros de Broma", "92929383", gian, 3L);


        // Crear enlaces de pago
        EnlacePago enlace1 = createEnlacePago(producto2, Instant.now(), Instant.now().plusSeconds(3600), plantilla1, "Pago de tamales");
        EnlacePago enlace2 = createEnlacePago(producto3, Instant.now(), Instant.now().plusSeconds(36000), plantilla2, "Pago de Comida");
        EnlacePago enlace3 = createEnlacePago(producto4, Instant.now(), Instant.now().plusSeconds(360000), plantilla1, "Pago de Negocio");

        createEnlacePago(producto2, Instant.now(), Instant.now().plusSeconds(360000), plantilla2, "Pago de arriendo");
        createEnlacePago(producto2, Instant.now(), Instant.now().plusSeconds(360000), plantilla2, "Pago de Panes");
        createEnlacePago(producto2, Instant.now(), Instant.now().plusSeconds(360000), plantilla2, "Pago de Carros");

        // Crear transacciones y enlaces a los enlaces de pago
        Transaccion transaccion1 = createTransaccion(producto1, 10000d);
        createTransaccionEnlace(enlace1, transaccion1, "192.168.1.1", "fingerprint1");

        Transaccion transaccion2 = createTransaccion(producto2, 900000d);
        createTransaccionEnlace(enlace2, transaccion2, "192.168.1.2", "fingerprint2");

        Transaccion transaccion3 = createTransaccion(producto3, 1000000d);
        createTransaccionEnlace(enlace3, transaccion3, "192.168.1.3", "fingerprint3");
    }

    private Usuario createUsuario(String primerNombre, String primerApellido, String numeroTelefono, String correo){
        Usuario usuario = new Usuario();
        usuario.setPrimerNombre(primerNombre);
        usuario.setPrimerApellido(primerApellido);

        usuario.setNumeroTelefono(numeroTelefono);
        usuario.setCorreo(correo);

        usuarioRepository.save(usuario);

        return usuario;
    }

    private Producto createProducto(String nombre, String codigo, Usuario usuario, Long limite) {
        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setCodigo(codigo);
        producto.setUsuario(usuario); // Set the Usuario for the Producto
        producto.setLimiteEnlacesPago(limite);
        productoRepository.save(producto);
        return producto;
    }


    private EnlacePago createEnlacePago(Producto producto, Instant fechaHoraDesde, Instant fechaHoraHasta, Plantilla plantilla, String nombre) {
        EnlacePago enlacePago = new EnlacePago();
        String codigo = RandomGenerator.generateRandomString(6);
        enlacePago.setProducto(producto);
        enlacePago.setCodigo(codigo);
        enlacePago.setNombre("Enlace de pago" + RandomGenerator.generateRandomString(6));
        enlacePago.setFechaHoraDesde(fechaHoraDesde);
        enlacePago.setFechaHoraHasta(fechaHoraHasta);
        enlacePago.setActivo(true);
        enlacePago.setUrl("https://localhost:8100/pago/");

        enlacePagoRepository.save(enlacePago);

        createPlantillaEnlacePago(codigo, plantilla);

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

    private Plantilla createPlantilla(String nombre, String codigo, List<CampoPlantilla> campos){
        Plantilla plantilla = new Plantilla();
        plantilla.setNombre(nombre);
        plantilla.setCodigo(codigo);
        plantilla.setCampos(campos);

        // plantillaRepository.save(plantilla);

        return plantilla;
    }

    private void createPlantillaEnlacePago(String codigo, Plantilla plantilla){
        PlantillaEnlacePago plantillaEnlacePago = new PlantillaEnlacePago();
        plantillaEnlacePago.setCodigo(codigo);
        plantillaEnlacePago.setPlantilla(plantilla);

        plantillaEnlacePagoRepository.save(plantillaEnlacePago);

    }
}
