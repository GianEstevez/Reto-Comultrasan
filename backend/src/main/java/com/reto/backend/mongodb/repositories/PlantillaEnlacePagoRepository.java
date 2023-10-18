package com.reto.backend.mongodb.repositories;

import com.reto.backend.mongodb.models.PlantillaEnlacePago;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlantillaEnlacePagoRepository extends MongoRepository<PlantillaEnlacePago, String> {

    PlantillaEnlacePago getPlantillaEnlacePagoByCodigoEnlace(String codigoEnlace);
}
