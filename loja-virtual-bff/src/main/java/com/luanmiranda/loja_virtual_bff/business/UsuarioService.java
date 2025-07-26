package com.luanmiranda.loja_virtual_bff.business;

import com.luanmiranda.loja_virtual_bff.api.request.UsuarioRequestDTO;
import com.luanmiranda.loja_virtual_bff.api.response.UsuarioResponseDTO;
import com.luanmiranda.loja_virtual_bff.infraestructure.clients.usuarioClient.UsuarioClient;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioClient usuarioClient;

    public UsuarioResponseDTO cadastrarUsuario(UsuarioRequestDTO usuarioRequestDTO) {
        return usuarioClient.gravaDadosUsuario(usuarioRequestDTO);
    }

    public UsuarioResponseDTO buscaUsuarioPorEmail(String email) {
        return usuarioClient.buscaUsuarioPorEmail(email);
    }

    public void deletaUsuarioPorEmail(String email) {
        try {
            usuarioClient.deletaDadosUsuario(email);
        } catch (FeignException.NotFound e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário com email " + email + " não encontrado.");
        } catch (FeignException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao excluir usuário: " + e.getMessage());
        }
    }
}