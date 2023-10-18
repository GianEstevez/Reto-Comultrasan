package com.reto.backend.postgresql.repositories;

import com.reto.backend.postgresql.models.TransaccionEnlace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaccionEnlaceRepository extends JpaRepository<TransaccionEnlace, Long> {
}