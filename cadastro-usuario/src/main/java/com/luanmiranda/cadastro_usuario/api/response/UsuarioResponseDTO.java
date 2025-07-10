package com.luanmiranda.cadastro_usuario.api.response;

import com.luanmiranda.cadastro_usuario.infrastructure.entities.EnderecoEntity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioResponseDTO {
    private Long id;
    private String nome;
    private String email;
    private String documento;
    private EnderecoResponseDTO endereco;
}
