package edu.br.infnet.tp3devops_jdbc.fornecedor.service;

import edu.br.infnet.tp3devops_jdbc.fornecedor.model.Fornecedor;
import edu.br.infnet.tp3devops_jdbc.fornecedor.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FornecedorService {

    private final FornecedorRepository fornecedorRepository;

    @Autowired
    public FornecedorService(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    public Fornecedor criarFornecedor(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    public Iterable<Fornecedor> listarFornecedores() {
        return fornecedorRepository.findAll();
    }

    public Fornecedor atualizarFornecedor(Long id, Fornecedor fornecedorAtualizado) {
        if (fornecedorRepository.existsById(id)) {
            fornecedorAtualizado.setId(id);
            return fornecedorRepository.save(fornecedorAtualizado);
        }
        return null;
    }

    public void deletarFornecedor(Long id) {
        fornecedorRepository.deleteById(id);
    }

    public Fornecedor buscarFornecedorPorId(Long id) {
        return fornecedorRepository.findById(id).orElse(null);
    }
}

