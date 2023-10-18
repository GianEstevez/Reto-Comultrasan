package com.reto.backend.mongodb.repositories;

import com.reto.backend.mongodb.models.Plantilla;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlantillaRepository extends MongoRepository<Plantilla, String> {
}
