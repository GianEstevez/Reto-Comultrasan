package com.reto.backend.mongodb.models;

import java.io.Serializable;

public record Comprador(String nombre, String documento, String correo, String numeroContacto) implements Serializable {
}
