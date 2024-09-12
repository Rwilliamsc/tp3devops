//package edu.br.infnet.tp3devops.produto.service;
//
//import edu.br.infnet.tp3devops.produto.model.Produto;
//import edu.br.infnet.tp3devops.produto.repository.ProdutoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//@Service
//public class ProdutoService {
//
//    @Autowired
//    private ProdutoRepository produtoRepository;
//
//    public Flux<Produto> listarTodos() {
//        return produtoRepository.findAll();
//    }
//
//    public Mono<Produto> buscarPorId(Long id) {
//        return produtoRepository.findById(id);
//    }
//
//    public Mono<Produto> criarProduto(Produto produto) {
//        return produtoRepository.save(produto);
//    }
//
//    public Mono<Produto> atualizarProduto(Long id, Produto produtoAtualizado) {
//        return produtoRepository.findById(id)
//                .flatMap(produtoExistente -> {
//                    produtoExistente.setNome(produtoAtualizado.getNome());
//                    produtoExistente.setPreco(produtoAtualizado.getPreco());
//                    return produtoRepository.save(produtoExistente);
//                });
//    }
//
//    public Mono<Void> excluirProduto(Long id) {
//        return produtoRepository.deleteById(id);
//    }
//}
//
