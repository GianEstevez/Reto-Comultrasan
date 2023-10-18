package com.reto.backend.mongodb.models;

import java.io.Serializable;

public record CampoCliente(String nombre, String numeroCuenta) implements Serializable {
}
