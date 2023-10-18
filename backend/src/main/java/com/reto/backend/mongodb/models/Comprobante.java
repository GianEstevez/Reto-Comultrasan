package com.reto.backend.mongodb.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Entity
@Document(collection = "comprobantes")
public class Comprobante {

    @Id
    String id;

    PlantillaEnlacePago plantillaEnlacePago;

    Boolean exitosa;

    String getCodigoTransaccion(){
        return this.plantillaEnlacePago.getCodigoTransaccion();
    }
}
