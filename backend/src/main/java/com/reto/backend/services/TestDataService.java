package com.reto.backend.services;


import java.time.Instant;
import java.util.List;

import com.reto.backend.mongodb.models.CampoPlantilla;
import com.reto.backend.mongodb.models.Plantilla;
import com.reto.backend.mongodb.models.PlantillaEnlacePago;
import com.reto.backend.mongodb.models.Vendedor;
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

        CampoPlantilla nombre = new CampoPlantilla("Nombre", "*", null);
        CampoPlantilla cedula = new CampoPlantilla("Cedula", "*", null);
        CampoPlantilla contacto = new CampoPlantilla("Contacto", "*", null);
        CampoPlantilla correo = new CampoPlantilla("Correo electrónico", "*", null);

        Plantilla plantillaComprador = createPlantilla("Datos de comprador", "C1", List.of(nombre, cedula, contacto, correo));

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

        Vendedor vendedorEdward = new Vendedor(edward.getPrimerNombre(), producto2.getCodigo());
        Vendedor vendedorGian = new Vendedor(gian.getPrimerNombre(), producto4.getCodigo());

        // Crear enlaces de pago
        EnlacePago enlace1 = createEnlacePago(producto2, Instant.now(), Instant.now().plusSeconds(3600), plantilla1, "Pago de tamales", vendedorEdward, plantillaComprador);
        EnlacePago enlace2 = createEnlacePago(producto3, Instant.now(), Instant.now().plusSeconds(36000), plantilla2, "Pago de Comida", vendedorEdward, plantillaComprador);
        EnlacePago enlace3 = createEnlacePago(producto4, Instant.now(), Instant.now().plusSeconds(360000), plantilla1, "Pago de Negocio", vendedorGian, plantillaComprador);

        createEnlacePago(producto2, Instant.now(), Instant.now().plusSeconds(360000), plantilla2, "Pago de arriendo",  vendedorEdward, plantillaComprador);
        createEnlacePago(producto2, Instant.now(), Instant.now().plusSeconds(360000), plantilla2, "Pago de Panes",  vendedorEdward, plantillaComprador);
        createEnlacePago(producto2, Instant.now(), Instant.now().plusSeconds(360000), plantilla2, "Pago de Carros",  vendedorEdward, plantillaComprador);

        // Crear transacciones y enlaces a los enlaces de pago
        Transaccion transaccion1 = createTransaccion(producto1, 10000d, true);
        createTransaccionEnlace(enlace1, transaccion1, "192.168.1.1", "fingerprint1");

        Transaccion transaccion2 = createTransaccion(producto2, 900000d, true);
        createTransaccionEnlace(enlace2, transaccion2, "192.168.1.2", "fingerprint2");

        Transaccion transaccion3 = createTransaccion(producto3, 1000000d, true);
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


    private EnlacePago createEnlacePago(Producto producto, Instant fechaHoraDesde, Instant fechaHoraHasta, Plantilla plantilla, String nombre, Vendedor vendedor, Plantilla comprador) {
        EnlacePago enlacePago = new EnlacePago();
        String codigo = RandomGenerator.generateRandomString(6);
        enlacePago.setProducto(producto);
        enlacePago.setCodigo(codigo);
        enlacePago.setNombre(nombre);
        enlacePago.setFechaHoraDesde(fechaHoraDesde);
        enlacePago.setFechaHoraHasta(fechaHoraHasta);
        enlacePago.setActivo(true);
        enlacePago.setUrl("https://localhost:8100/pago/");

        enlacePagoRepository.save(enlacePago);

        createPlantillaEnlacePago(codigo, plantilla, vendedor, comprador);

        return enlacePago;
    }

    private Transaccion createTransaccion(Producto producto, Double valor, Boolean exitosa) {
        Transaccion transaccion = new Transaccion();
        transaccion.setProducto(producto);
        transaccion.setValor(valor);
        transaccion.setCodigo(RandomGenerator.generateRandomString(12));
        transaccion.setExitosa(exitosa);

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

        plantillaRepository.save(plantilla);

        return plantilla;
    }

    private void createPlantillaEnlacePago(String codigo, Plantilla plantilla, Vendedor vendedor, Plantilla comprador){
        PlantillaEnlacePago plantillaEnlacePago = new PlantillaEnlacePago();
        plantillaEnlacePago.setCodigoEnlace(codigo);
        plantillaEnlacePago.setPlantilla(plantilla);
        plantillaEnlacePago.setVendedor(vendedor);
        plantillaEnlacePago.setComprador(comprador);

        plantillaEnlacePagoRepository.save(plantillaEnlacePago);

    }
}
