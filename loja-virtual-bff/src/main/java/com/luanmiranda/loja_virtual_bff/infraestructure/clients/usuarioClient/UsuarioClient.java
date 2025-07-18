package com.luanmiranda.loja_virtual_bff.infraestructure.clients.usuarioClient;

import com.luanmiranda.loja_virtual_bff.api.request.UsuarioRequestDTO;
import com.luanmiranda.loja_virtual_bff.api.response.UsuarioResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "usuario-api", url = "localhost:8282")
public interface UsuarioClient {
    @PostMapping("/user")
    ResponseEntity<UsuarioResponseDTO> gravaDadosUsuario(@RequestBody UsuarioRequestDTO usuarioRequestDTO);


    @GetMapping("/user")
    ResponseEntity<UsuarioResponseDTO> buscarUsuarioPorEmail(@RequestParam("email") String email);

    @DeleteMapping("/user")
    ResponseEntity<Void> excluirUsuario(@RequestParam("email") String email);
}
