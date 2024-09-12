package edu.br.infnet.tp3devops_jdbc.fornecedor.controller;

import edu.br.infnet.tp3devops_jdbc.fornecedor.model.Fornecedor;
import edu.br.infnet.tp3devops_jdbc.fornecedor.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @PostMapping
    @CrossOrigin
    public ResponseEntity<Fornecedor> criarFornecedor(@RequestBody Fornecedor fornecedor) {
        return new ResponseEntity<>(fornecedorService.criarFornecedor(fornecedor), HttpStatus.CREATED);
    }

    @GetMapping
    @CrossOrigin
    @ResponseStatus(code = HttpStatus.OK)
    public Iterable<Fornecedor> listarFornecedores() {
        return fornecedorService.listarFornecedores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> buscarFornecedorPorId(@PathVariable Long id) {
        Fornecedor fornecedor = fornecedorService.buscarFornecedorPorId(id);
        if (fornecedor != null) {
            return new ResponseEntity<>(fornecedor, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> atualizarFornecedor(@PathVariable Long id, @RequestBody Fornecedor fornecedor) {
        Fornecedor fornecedorAtualizado = fornecedorService.atualizarFornecedor(id, fornecedor);
        if (fornecedorAtualizado != null) {
            return new ResponseEntity<>(fornecedorAtualizado, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFornecedor(@PathVariable Long id) {
        fornecedorService.deletarFornecedor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

