package com.luanmiranda.loja_virtual_bff.business;

import com.luanmiranda.loja_virtual_bff.api.request.CartaoRequestDTO;
import com.luanmiranda.loja_virtual_bff.infraestructure.clients.pagamentoClient.PagamentoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PagamentoService {

    private final PagamentoClient pagamentoClient;

    public Boolean verificaPagamento(CartaoRequestDTO cartaoRequestDTO){
        return pagamentoClient.verificaPagamento(cartaoRequestDTO);
    }
}