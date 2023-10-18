package com.reto.backend.mongodb.repositories;

import com.reto.backend.mongodb.models.Comprobante;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ComprobanteRepository extends MongoRepository<Comprobante, String> {

    Comprobante getComprobanteByCodigoTransaccion(String codigoTransaccion);

    List<Comprobante> getComprobantesByCodigoEnlace(String codigoEnlace);
}
