package com.reto.backend.mongodb.repositories;

import com.reto.backend.mongodb.models.Plantilla;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlantillasRepository extends MongoRepository<Plantilla, String> {
}
