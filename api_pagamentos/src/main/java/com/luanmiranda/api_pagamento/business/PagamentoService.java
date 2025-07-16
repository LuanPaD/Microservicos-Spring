package com.luanmiranda.api_pagamento.business;

import com.luanmiranda.api_pagamento.controller.request.CartaoRequestDTO;
import com.luanmiranda.api_pagamento.infraestructure.client.PagamentoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PagamentoService {
    private final PagamentoClient pagamentoClient;

    public boolean verificaPagamento(CartaoRequestDTO cartaoRequestDTO) {
        // Verifica se o cartao e valido
        return pagamentoClient.verificaCartao(cartaoRequestDTO);
    }

}
