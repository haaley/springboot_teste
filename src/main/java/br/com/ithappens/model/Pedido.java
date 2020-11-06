package br.com.ithappens.model;

import lombok.Data;

import java.util.Set;

@Data
public class Pedido {

    private Long idPedido;
    private Long idFilial;
    private String tipoPedido;
    private Set<Produto> itensPedido;

}