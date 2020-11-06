package br.com.ithappens.controller;

import br.com.ithappens.model.Estoque;
import br.com.ithappens.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EstoqueController {

    private final EstoqueService estoqueService;

    @Autowired
    public EstoqueController(EstoqueService estoqueService) {
        this.estoqueService = estoqueService;
    }

    @GetMapping(value = "/filiais/{idFilial}/estoque")
    public ResponseEntity<Estoque> getEstoqueFilial(@PathVariable Long idFilial) {
        Estoque estoque = estoqueService.listarEstoque(idFilial);
        return ResponseEntity.ok().body(estoque);
    }

}
