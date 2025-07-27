package com.luanmiranda.loja_virtual_bff.api;

import com.luanmiranda.loja_virtual_bff.api.request.CompraRequestDTO;
import com.luanmiranda.loja_virtual_bff.api.request.UsuarioRequestDTO;
import com.luanmiranda.loja_virtual_bff.api.response.ProductsDTO;
import com.luanmiranda.loja_virtual_bff.api.response.UsuarioResponseDTO;
import com.luanmiranda.loja_virtual_bff.business.LojaVirtualService;
import com.luanmiranda.loja_virtual_bff.business.ProdutosService;
import com.luanmiranda.loja_virtual_bff.business.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/loja-virtual")
@RequiredArgsConstructor
@Tag(name = "loja-virtual-api")
public class LojaVirtualController {
    private final ProdutosService produtosService;
    private final UsuarioService usuarioService;
    private final LojaVirtualService lojaVirtualService;

    @Operation(summary = "Busca todos os produtos", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),
    })
    @GetMapping("/produtos")
    public ResponseEntity<List<ProductsDTO>> buscaTodosProdutos() {
        return ResponseEntity.ok(produtosService.buscaTodosProdutos());
    }

    @Operation(summary = "Busca produtos por nome", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),
    })
    @GetMapping("/produtos/{nome}")
    public ResponseEntity<ProductsDTO> buscaProdutosPorNome(@PathVariable("nome") String nome) {
        return ResponseEntity.ok(produtosService.buscaProdutosPorNome(nome));
    }

    @Operation(summary = "Cadastrar Usuario", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cadastro realizado com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao cadastrar usuario"),
    })
    @PostMapping("/usuario")
    public ResponseEntity<UsuarioResponseDTO> cadastraUsuario(@RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        return ResponseEntity.ok(usuarioService.cadastrarUsuario(usuarioRequestDTO));
    }

    @Operation(summary = "Deleta usuario por email", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Usuário deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno ao deletar usuário")
    })
    @DeleteMapping("/usuario/{email}")
    public ResponseEntity<Void> deletaUsuarioPorEmail(@PathVariable("email") String email) {
        usuarioService.deletaUsuarioPorEmail(email);
        return ResponseEntity.accepted().build();
    }


    @Operation(summary = "Realiza compra de produto", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Compra realizado com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar compra"),
    })
    @PostMapping("/compra")
    public ResponseEntity<String> compraProdutos(@RequestBody CompraRequestDTO compraRequestDTO) {
        return ResponseEntity.ok(lojaVirtualService.realizaCompraProdutos(compraRequestDTO));
    }


}