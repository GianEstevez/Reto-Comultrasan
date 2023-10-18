package com.reto.backend.services;

import com.reto.backend.mongodb.models.PlantillaEnlacePago;
import com.reto.backend.mongodb.repositories.PlantillaEnlacePagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    PlantillaEnlacePagoRepository plantillaEnlacePagoRepository;

    public PlantillaEnlacePago getPlantillaEnlaceByCodigo(String codigoEnlace){

        PlantillaEnlacePago plantillaEnlacePago = plantillaEnlacePagoRepository.getPlantillaEnlacePagoByCodigo(codigoEnlace);

        return plantillaEnlacePago;
    }
}
