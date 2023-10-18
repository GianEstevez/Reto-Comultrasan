package com.reto.backend.services;

import com.reto.backend.mongodb.models.Comprobante;
import com.reto.backend.mongodb.models.PlantillaEnlacePago;
import com.reto.backend.mongodb.repositories.ComprobanteRepository;
import com.reto.backend.mongodb.repositories.PlantillaEnlacePagoRepository;
import com.reto.backend.utils.RandomGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    PlantillaEnlacePagoRepository plantillaEnlacePagoRepository;

    @Autowired
    ComprobanteRepository comprobanteRepository;

    public PlantillaEnlacePago getPlantillaEnlaceByCodigo(String codigoEnlace){

        PlantillaEnlacePago plantillaEnlacePago = plantillaEnlacePagoRepository.getPlantillaEnlacePagoByCodigoEnlace(codigoEnlace);
        plantillaEnlacePago.setCodigoTransaccion(RandomGenerator.generateRandomString(10));

        return plantillaEnlacePago;
    }

    public Comprobante getComprobanteByCodigoTransaccion(String codigoTransaccion){

        return comprobanteRepository.getComprobanteByCodigoTransaccion(codigoTransaccion);
    }

    public List<Comprobante> getTransaccionesEnlaceByCodigo(String codigoeEnlace){

         return  comprobanteRepository.getComprobantesByCodigoEnlace(codigoeEnlace);
    }
}
