package com.reto.backend.mongodb.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Document(collection = "plantillasEnlacePago")
public class PlantillaEnlacePago implements Serializable {

    @Id
    private String id;
    private String codigo;

    private CampoCliente campoCliente;

    private CampoComprador campoComprador;

    private Plantilla plantilla;
}
