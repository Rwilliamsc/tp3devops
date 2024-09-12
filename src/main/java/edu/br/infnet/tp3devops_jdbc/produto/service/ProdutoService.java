package edu.br.infnet.tp3devops_jdbc.produto.service;
import edu.br.infnet.tp3devops_jdbc.produto.model.Produto;
import edu.br.infnet.tp3devops_jdbc.produto.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Flux<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }

    public Mono<Produto> getProdutoById(Long id) {
        return produtoRepository.findById(id);
    }

    public Mono<Produto> createProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Mono<Produto> updateProduto(Long id, Produto produto) {
        return produtoRepository.findById(id)
                .flatMap(existingProduto -> {
                    existingProduto.setNome(produto.getNome());
                    existingProduto.setPreco(produto.getPreco());
                    return produtoRepository.save(existingProduto);
                });
    }

    public Mono<Void> deleteProduto(Long id) {
        return produtoRepository.deleteById(id);
    }
}
