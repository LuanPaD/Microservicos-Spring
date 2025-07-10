package com.luanmiranda.cadastro_usuario.api.converter;

import com.luanmiranda.cadastro_usuario.api.request.EnderecoRequestDTO;
import com.luanmiranda.cadastro_usuario.api.request.UsuarioRequestDTO;
import com.luanmiranda.cadastro_usuario.api.response.EnderecoResponseDTO;
import com.luanmiranda.cadastro_usuario.api.response.UsuarioResponseDTO;
import com.luanmiranda.cadastro_usuario.infrastructure.entities.EnderecoEntity;
import com.luanmiranda.cadastro_usuario.infrastructure.entities.UsuarioEntity;
import org.springframework.stereotype.Component;

@Component
public class UsuarioConverter {

    public UsuarioEntity paraUsuarioEntity(UsuarioRequestDTO usuarioDTO) {
        if (usuarioDTO == null) {
            return null;
        }

        return UsuarioEntity.builder()
                .nome(usuarioDTO.getNome())
                .email(usuarioDTO.getEmail())
                .documento(usuarioDTO.getDocumento())
                .endereco(paraEnderecoEntity(usuarioDTO.getEndereco()))
                .build();
    }

   private EnderecoEntity paraEnderecoEntity(EnderecoRequestDTO enderecoDTO) {
        if (enderecoDTO == null) {
            return null;
        }

        return EnderecoEntity.builder()
                .rua(enderecoDTO.getRua())
                .numero(enderecoDTO.getNumero())
                .bairro(enderecoDTO.getBairro())
                .complemento(enderecoDTO.getComplemento())
                .cidade(enderecoDTO.getCidade())
                .cep(enderecoDTO.getCep())
                .build();
   }

    public UsuarioResponseDTO paraUsuarioResponseDTO(UsuarioEntity usuarioEntity) {
        if (usuarioEntity == null) {
            return null;
        }

        return UsuarioResponseDTO.builder()
                .nome(usuarioEntity.getNome())
                .email(usuarioEntity.getEmail())
                .documento(usuarioEntity.getDocumento())
                .endereco(paraEnderecoResponseDTO(usuarioEntity.getEndereco()))
                .build();
    }

    private EnderecoResponseDTO paraEnderecoResponseDTO(EnderecoEntity enderecoEntity) {
        if (enderecoEntity == null) {
            return null;
        }

        return EnderecoResponseDTO.builder()
                .rua(enderecoEntity.getRua())
                .numero(enderecoEntity.getNumero())
                .bairro(enderecoEntity.getBairro())
                .complemento(enderecoEntity.getComplemento())
                .cidade(enderecoEntity.getCidade())
                .cep(enderecoEntity.getCep())
                .build();
    }
}
