package com.luanmiranda.cadastro_usuario.infrastructure.repository;

import com.luanmiranda.cadastro_usuario.infrastructure.entities.UsuarioEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    UsuarioEntity findByEmail(String email);

    @Transactional
    void deleteByEmail(String email);
}
