package edu.br.infnet.tp3devops.fornecedor.repository;

import edu.br.infnet.tp3devops.fornecedor.model.Fornecedor;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FornecedorRepository extends CrudRepository<Fornecedor, Long> {

    @Override
    <S extends Fornecedor> S save(S fornecedor);

    @Override
    Optional<Fornecedor> findById(Long id);

    @Modifying
    @Query("UPDATE fornecedor SET nome = :nome, cnpj := cnpj , endereco = :endereco WHERE id = :id")
    void update(Long id, String nome, String email);

    @Override
    void deleteById(Long id);
}

