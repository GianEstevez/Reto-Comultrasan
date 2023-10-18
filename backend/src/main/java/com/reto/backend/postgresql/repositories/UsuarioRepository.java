package com.reto.backend.postgresql.repositories;

import com.reto.backend.postgresql.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}