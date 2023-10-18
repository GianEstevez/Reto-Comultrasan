package com.reto.backend.mongodb.models;

import java.io.Serializable;

public record CampoPlantilla(String nombre, String regex, String contenido) implements Serializable {
}