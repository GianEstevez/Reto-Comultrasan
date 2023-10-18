package com.reto.backend.postgresql.repositories;

import com.reto.backend.postgresql.models.Producto;
import com.reto.backend.postgresql.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    List<Producto> getProductosByUsuario(Usuario usuario);

    Producto getProductoByCodigo(String codigo);

    @Query("SELECT SUM(t.valor) FROM Transaccion t WHERE t.producto = :producto")
    Double calculateSaldo(@Param("producto") Producto producto);
}