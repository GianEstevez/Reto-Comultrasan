package com.reto.backend.postgresql.repositories;

import com.reto.backend.postgresql.models.EnlacePago;
import com.reto.backend.postgresql.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EnlacePagoRepository extends JpaRepository<EnlacePago, Long>, JpaSpecificationExecutor<EnlacePago> {

    @Query("select e from EnlacePago e where e.producto = ?1")
    List<EnlacePago> getEnlacePagosByProducto(Producto producto);
}