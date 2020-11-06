package br.com.ithappens.controller;

import br.com.ithappens.model.Produto;
import br.com.ithappens.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> getProduto(@PathVariable Long id) {
        Produto novoProduto = produtoService.getProduto(id);
        return ResponseEntity.of(Optional.of(novoProduto));
    }

    @PostMapping(value = "/")
    public ResponseEntity<Produto> novoProduto(@RequestBody Produto produto) {
        produtoService.cadastrarProduto(produto);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/")
    public ResponseEntity<Produto> atualizarProduto(@RequestBody Produto produto) {
        produtoService.updateProduto(produto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Collection<Produto>> getProdutos() {
        Collection<Produto> produtos = produtoService.listProdutos();
        return ResponseEntity.ok().body(produtos);
    }
}
