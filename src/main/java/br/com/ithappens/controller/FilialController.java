package br.com.ithappens.controller;

import br.com.ithappens.mapper.FilialMapper;
import br.com.ithappens.model.Filial;
import br.com.ithappens.service.FilialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RequestMapping(value = "/api/filial")
@RestController
public class FilialController {
    private final FilialService filialService;

    @Autowired
    public FilialController(FilialService filialService) {
        this.filialService = filialService;
    }

    @GetMapping
    public ResponseEntity<Collection<Filial>> getFiliais(@RequestParam("descricao") Optional<String> descricao) {
        Collection<Filial> filiais = filialService.listFiliais(descricao);
        return ResponseEntity.ok().body(filiais);
    }

    @PostMapping
    public ResponseEntity<Collection<Filial>> saveFilial(@RequestBody Filial filial) {
        filialService.cadastrarFilial(filial);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Collection<Filial>> updateFilial(@RequestBody Filial filial) throws Exception {
        filialService.updateFilial(filial);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Filial> getFilial(@PathVariable Long id) {
        Filial filial = filialService.getFilial(id);
        return ResponseEntity.ok().body(filial);
    }

}
