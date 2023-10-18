package com.reto.backend.mongodb.models;

import java.io.Serializable;

public record Vendedor(String nombre, String numeroCuenta) implements Serializable {
}
