package com.brunostaine.api.park.repository;

import com.brunostaine.api.park.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
