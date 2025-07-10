package com.luanmiranda.cadastro_usuario.api.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnderecoRequestDTO {
    private String rua;
    private String numero;
    private String bairro;
    private String complemento;
    private String cidade;
    private String cep;
}
