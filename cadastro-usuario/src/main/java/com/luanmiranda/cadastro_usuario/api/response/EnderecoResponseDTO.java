package com.luanmiranda.cadastro_usuario.api.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnderecoResponseDTO {
    private String rua;
    private String numero;
    private String bairro;
    private String complemento;
    private String cidade;
    private String cep;
}
