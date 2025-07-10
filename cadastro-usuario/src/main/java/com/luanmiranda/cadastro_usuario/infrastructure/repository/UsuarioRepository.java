package com.luanmiranda.cadastro_usuario.infrastructure.repository;

import com.luanmiranda.cadastro_usuario.infrastructure.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
}
