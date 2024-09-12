package edu.br.infnet.tp3devops_jdbc.produto.controller;

import edu.br.infnet.tp3devops_jdbc.produto.model.Produto;
import edu.br.infnet.tp3devops_jdbc.produto.service.ProdutoService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public Flux<Produto> getAllProdutos() {
        return produtoService.getAllProdutos();
    }

    @GetMapping("/{id}")
    public Mono<Produto> getProdutoById(@PathVariable Long id) {
        return produtoService.getProdutoById(id);
    }

    @PostMapping
    public Mono<Produto> createProduto(@RequestBody Produto produto) {
        return produtoService.createProduto(produto);
    }

    @PutMapping("/{id}")
    public Mono<Produto> updateProduto(@PathVariable Long id, @RequestBody Produto produto) {
        return produtoService.updateProduto(id, produto);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteProduto(@PathVariable Long id) {
        return produtoService.deleteProduto(id);
    }
}
