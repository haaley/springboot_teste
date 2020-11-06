package br.com.ithappens.service;

import br.com.ithappens.mapper.EstoqueMapper;
import br.com.ithappens.mapper.PedidoMapper;
import br.com.ithappens.mapper.ProdutoMapper;
import br.com.ithappens.model.ItemPedidoEstoque;
import br.com.ithappens.model.Pedido;
import br.com.ithappens.model.Produto;
import br.com.ithappens.model.exception.ResourceNotFoundException;
import org.bouncycastle.eac.EACException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    private final PedidoMapper pedidoMapper;
    private final EstoqueMapper estoqueMapper;
    private final ProdutoMapper produtoMapper;

    @Autowired
    public PedidoService(PedidoMapper pedidoMapper, EstoqueMapper estoqueMapper, ProdutoMapper produtoMapper) {
        this.pedidoMapper = pedidoMapper;
        this.estoqueMapper = estoqueMapper;
        this.produtoMapper = produtoMapper;
    }

    public boolean novoPedido(Optional<Pedido> pedido) throws Exception {
        try {
            Pedido pedidoObj;
            if (pedido.isPresent()) {
                pedidoObj = pedido.get();
                if (pedidoObj.getTipoPedido().equals("ENTRADA")) {
                    estoqueMapper.insereProdutosEstoque(pedidoObj.getTipoPedido(), pedidoObj.getIdFilial(), pedidoObj.getItensPedido());
                } else if (pedidoObj.getTipoPedido().equals("SAIDA")) {
                    if (verificaQuantidade(pedidoObj)) {
                        estoqueMapper.insereProdutosEstoque(pedidoObj.getTipoPedido(), pedidoObj.getIdFilial(), pedidoObj.getItensPedido());
                    } else {
                        throw new ResourceNotFoundException("Um ou mais produtos não possuem quantidade no estoque");
                    }
                }
                pedidoMapper.novoPedido(pedidoObj);
                pedidoMapper.insertItensPedido(pedidoObj.getItensPedido(), pedidoObj.getIdPedido());
                return true;
            }
            return false;
        } catch (RuntimeException e) {
            throw e;
        }
    }

    public Collection<Pedido> getPedidos(){
        return pedidoMapper.listPedidos();
    }

    private Boolean verificaQuantidade(Pedido pedido) {

        Iterator<Produto> it = pedido.getItensPedido().iterator();
        while (it.hasNext()) {
            Produto p = it.next();
            Long quantidade = estoqueMapper.verificaQuantidade(p.getIdProduto(), pedido.getIdFilial());
            if (p.getQuantidade() > quantidade) {
                return false;
            }
        }
        return true;
    }

}
