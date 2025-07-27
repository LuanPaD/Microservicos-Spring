package com.luanmiranda.cadastro_usuario.api;

import com.luanmiranda.cadastro_usuario.api.request.UsuarioRequestDTO;
import com.luanmiranda.cadastro_usuario.api.response.UsuarioResponseDTO;
import com.luanmiranda.cadastro_usuario.business.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;

    @PostMapping()
    public ResponseEntity<UsuarioResponseDTO> gravaDadosUsuario(@RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        return ResponseEntity.ok(
            usuarioService.gravarUsuario(usuarioRequestDTO)
        );
    }

    @GetMapping()
    public ResponseEntity<UsuarioResponseDTO> buscarUsuarioPorEmail(@RequestParam ("email") String email) {
        return ResponseEntity.ok(
            usuarioService.buscaDadosUsuario(email)
        );
    }

    @DeleteMapping
    public ResponseEntity<String> excluirUsuario(@RequestParam("email") String email) {
        boolean usuarioExcluido = usuarioService.excluirUsuario(email);

        if (!usuarioExcluido) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Usuário com email " + email + " não encontrado.");
        }

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body("Usuário com email " + email + " excluído com sucesso.");
    }


}
