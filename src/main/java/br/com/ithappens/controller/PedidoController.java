package br.com.ithappens.controller;

import br.com.ithappens.model.Filial;
import br.com.ithappens.model.Pedido;
import br.com.ithappens.model.Produto;
import br.com.ithappens.service.FilialService;
import br.com.ithappens.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RequestMapping(value = "/api/filial/{idFilial}/pedido")
@RestController
public class PedidoController {
    private final PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity novoPedido(@PathVariable Long idFilial, @RequestBody Optional<Pedido> pedido) throws Exception {
        pedido.get().setIdFilial(idFilial);
        pedidoService.novoPedido(pedido);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity getPedidos(@PathVariable Long idFilial, @RequestBody Optional<Pedido> pedido) throws Exception {
        pedido.get().setIdFilial(idFilial);
        pedidoService.novoPedido(pedido);
        return ResponseEntity.ok().build();
    }
}
