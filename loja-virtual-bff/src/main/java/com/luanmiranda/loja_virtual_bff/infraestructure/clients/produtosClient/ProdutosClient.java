package com.luanmiranda.loja_virtual_bff.infraestructure.clients.produtosClient;

import com.luanmiranda.loja_virtual_bff.api.request.UsuarioRequestDTO;
import com.luanmiranda.loja_virtual_bff.api.response.UsuarioResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "produtos-api", url = "localhost:8181")
public interface ProdutosClient {
    @PostMapping("/produtos")
    ResponseEntity<UsuarioResponseDTO> gravaDadosUsuario(@RequestBody UsuarioRequestDTO usuarioRequestDTO);


    @GetMapping("/user")
    ResponseEntity<UsuarioResponseDTO> buscarUsuarioPorEmail(@RequestParam("email") String email);

    @DeleteMapping("/user")
    ResponseEntity<Void> excluirUsuario(@RequestParam("email") String email);
}
