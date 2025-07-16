package com.luanmiranda.api_pagamento.controller.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CartaoRequestDTO {
    private String nome;
    private String numeroCartao;
    private String mes;
    private String ano;
    private String ccv;
    private EnderecoRequestDTO enderecoRequestDTO;
}
