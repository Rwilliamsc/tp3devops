//package edu.br.infnet.tp3devops.produto.controller;
//
//import edu.br.infnet.tp3devops.produto.model.Produto;
//import edu.br.infnet.tp3devops.produto.service.ProdutoService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//@RestController
//@RequestMapping("/api/produtos")
//public class ProdutoController {
//
//    @Autowired
//    private ProdutoService produtoService;
//
//    @GetMapping
//    public Flux<Produto> listarProdutos() {
//        return produtoService.listarTodos();
//    }
//
//    @GetMapping("/{id}")
//    public Mono<ResponseEntity<Produto>> buscarProdutoPorId(@PathVariable Long id) {
//        return produtoService.buscarPorId(id)
//                .map(produto -> ResponseEntity.ok(produto))
//                .defaultIfEmpty(ResponseEntity.notFound().build());
//    }
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public Mono<Produto> criarProduto(@RequestBody Produto produto) {
//        return produtoService.criarProduto(produto);
//    }
//
//    @PutMapping("/{id}")
//    public Mono<ResponseEntity<Produto>> atualizarProduto(@PathVariable Long id, @RequestBody Produto produto) {
//        return produtoService.atualizarProduto(id, produto)
//                .map(produtoAtualizado -> ResponseEntity.ok(produtoAtualizado))
//                .defaultIfEmpty(ResponseEntity.notFound().build());
//    }
//
//    @DeleteMapping("/{id}")
//    public Mono<ResponseEntity<Void>> excluirProduto(@PathVariable Long id) {
//        return produtoService.excluirProduto(id)
//                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)))
//                .defaultIfEmpty(ResponseEntity.notFound().build());
//    }
//}
//
