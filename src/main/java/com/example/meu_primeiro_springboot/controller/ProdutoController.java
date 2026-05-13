package com.example.meu_primeiro_springboot.controller;

import com.example.meu_primeiro_springboot.exceptions.RecursoNaoEncontradoException;
import com.example.meu_primeiro_springboot.model.Produto;
import com.example.meu_primeiro_springboot.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping //não coloco nada pois ao digitar ("/api/produtos") por padrão vai fazer o get dos produtos
    public List<Produto> listarProdutos() {
        return produtoService.listarProdutos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarProduto (@PathVariable Long id) { //pathvariable - Pega o {id} da URL Converte pra Long, dps passa pro metodo
        Produto produto = produtoService.buscarPorId(id); //preciso manipular o retorno antes de devolver
        return ResponseEntity.ok(produto);
    }

    @PostMapping //sem endpoint pq quando fizer um post em api/produtos vai inserir no banco
    public Produto criarProduto (@RequestBody Produto produto) { //o request tranforma o json em objeto produto
        return produtoService.salvarProduto(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto (@PathVariable Long id) {
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build(); //poderia colocar um boolean
    }

}
