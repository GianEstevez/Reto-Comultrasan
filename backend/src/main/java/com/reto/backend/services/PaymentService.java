package com.reto.backend.services;

import com.reto.backend.mongodb.models.PlantillaEnlacePago;
import com.reto.backend.mongodb.repositories.PlantillaEnlacePagoRepository;
import com.reto.backend.utils.RandomGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    PlantillaEnlacePagoRepository plantillaEnlacePagoRepository;

    public PlantillaEnlacePago getPlantillaEnlaceByCodigo(String codigoEnlace){

        PlantillaEnlacePago plantillaEnlacePago = plantillaEnlacePagoRepository.getPlantillaEnlacePagoByCodigoEnlace(codigoEnlace);
        plantillaEnlacePago.setCodigoTransaccion(RandomGenerator.generateRandomString(10));

        return plantillaEnlacePago;
    }

    // public List<TransaccionEnlaceDTO> getTransaccionesENlaceByCodigo(String codigoeEnlace){
    //
    // }
}
