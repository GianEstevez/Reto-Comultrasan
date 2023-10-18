package com.reto.backend.postgresql.repositories;

import com.reto.backend.postgresql.models.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {
}