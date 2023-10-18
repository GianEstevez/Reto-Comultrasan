package com.reto.backend.mongodb.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Document(collection = "plantillas")
public class Plantilla implements Serializable {

    @Id
    private String id;
    private String codigo;

    private String nombre;

    private List<CampoPlantilla> campos;
}
