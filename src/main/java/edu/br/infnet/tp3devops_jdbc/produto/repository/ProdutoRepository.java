package edu.br.infnet.tp3devops_jdbc.produto.repository;

import edu.br.infnet.tp3devops_jdbc.produto.model.Produto;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends ReactiveCrudRepository<Produto, Long> { }