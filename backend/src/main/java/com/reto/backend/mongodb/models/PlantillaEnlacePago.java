package com.reto.backend.mongodb.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
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
    private String codigoEnlace;

    @Transient
    private String codigoTransaccion;

    private Vendedor vendedor;

    private Plantilla comprador;

    private Plantilla plantilla;

    private Double valor;
}
