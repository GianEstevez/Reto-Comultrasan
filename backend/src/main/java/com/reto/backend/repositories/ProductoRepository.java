package com.reto.backend.repositories;

import com.reto.backend.models.Producto;
import com.reto.backend.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    public List<Producto> getProductosByUsuario(Usuario usuario);

    @Query("SELECT SUM(t.valor) FROM Transaccion t WHERE t.producto = :producto")
    Double calculateSaldo(@Param("producto") Producto producto);
}