package com.luanmiranda.api_pagamento.infraestructure.client;

import com.luanmiranda.api_pagamento.controller.request.CartaoRequestDTO;
import org.springframework.stereotype.Component;

import java.util.Objects;

// Mock de verificacao de cartao
@Component
public class PagamentoClient {

    public Boolean verificaCartao(CartaoRequestDTO cartaoRequestDTO) {
        if (cartaoRequestDTO.getNumeroCartao().endsWith("8080")) {
            return true;
        }

        return false;
    }
}
