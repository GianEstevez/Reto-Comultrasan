package com.reto.backend.repositories;

import com.reto.backend.models.EnlacePago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EnlacePagoRepository extends JpaRepository<EnlacePago, Long>, JpaSpecificationExecutor<EnlacePago> {
}