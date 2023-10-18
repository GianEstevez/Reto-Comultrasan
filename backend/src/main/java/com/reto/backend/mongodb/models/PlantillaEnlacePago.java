package com.reto.backend.mongodb.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Entity
@Document(collection = "plantillasEnlacePago")
public class PlantillaEnlacePago {

    @Id
    private String id;
    private String codigo;

    @ManyToOne
    @JoinColumn(name = "plantilla_id")
    private Plantilla plantilla;
}
