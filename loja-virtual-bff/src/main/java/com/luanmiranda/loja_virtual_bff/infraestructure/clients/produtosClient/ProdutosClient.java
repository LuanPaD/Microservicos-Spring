package com.luanmiranda.loja_virtual_bff.infraestructure.clients.produtosClient;

import com.luanmiranda.loja_virtual_bff.api.response.ProductsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "produtos-api", url = "localhost:8181")
public interface ProdutosClient {
    @GetMapping("/produtos/")
    List<ProductsDTO> buscaTodosProdutos();

    @GetMapping("/produtos/{nome}")
    ProductsDTO buscaProdutoPorNome(@PathVariable ("nome") String nome);
}
