package com.luanmiranda.loja_virtual_bff.infraestructure.clients.pagamentoClient;

import com.luanmiranda.loja_virtual_bff.api.request.CartaoRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "pagamento-api", url = "localhost:8484")
public interface PagamentoClient {

    @PostMapping("/pagamentos")
    Boolean verificaPagamento(@RequestBody CartaoRequestDTO cartaoRequestDTO);
}
