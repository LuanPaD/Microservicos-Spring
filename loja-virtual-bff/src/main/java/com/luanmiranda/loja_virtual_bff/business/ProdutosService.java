package com.luanmiranda.loja_virtual_bff.business;

import com.luanmiranda.loja_virtual_bff.api.response.ProductsDTO;
import com.luanmiranda.loja_virtual_bff.infraestructure.clients.produtosClient.ProdutosClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutosService {

    private final ProdutosClient client;

    public List<ProductsDTO> buscaTodosProdutos() {
        return client.buscaTodosProdutos();
    }

    public ProductsDTO buscaProdutosPorNome(String nome) {
        return client.buscaProdutoPorNome(nome);
    }


}