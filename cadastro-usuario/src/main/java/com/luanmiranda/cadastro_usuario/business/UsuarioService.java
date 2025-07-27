package com.luanmiranda.cadastro_usuario.business;

import com.luanmiranda.cadastro_usuario.api.converter.UsuarioConverter;
import com.luanmiranda.cadastro_usuario.api.request.UsuarioRequestDTO;
import com.luanmiranda.cadastro_usuario.api.response.UsuarioResponseDTO;
import com.luanmiranda.cadastro_usuario.infrastructure.entities.UsuarioEntity;
import com.luanmiranda.cadastro_usuario.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioConverter usuarioConverter;

    public UsuarioEntity cadastrarUsuario(UsuarioEntity usuarioEntity) {
        return usuarioRepository.saveAndFlush(usuarioEntity);
    }

    public UsuarioResponseDTO gravarUsuario(UsuarioRequestDTO usuarioRequestDTO) {
        try {
            UsuarioEntity usuarioEntity = cadastrarUsuario(usuarioConverter.paraUsuarioEntity(usuarioRequestDTO));
            return usuarioConverter.paraUsuarioResponseDTO(usuarioEntity);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao gravar dados de usuário", e);
        }
    }

    public UsuarioResponseDTO buscaDadosUsuario(String email) {
        return usuarioConverter.paraUsuarioResponseDTO(
            usuarioRepository.findByEmail(email)
        );
    }

    public boolean excluirUsuario(String email) {
        try {
            if (usuarioRepository.existsByEmail(email)) {
                usuarioRepository.deleteByEmail(email);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao excluir usuário", e);
        }
    }
}
