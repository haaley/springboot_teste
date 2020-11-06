package br.com.ithappens.mapper;

import br.com.ithappens.model.Filial;
import br.com.ithappens.model.ItemPedidoEstoque;
import br.com.ithappens.model.Pedido;
import br.com.ithappens.model.Produto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Mapper
@Repository
public interface EstoqueMapper {

  Collection<Produto> findByFilial(Long idFilial);

  void insert(Filial filial);

  void updateEstoque(@Param("itemPedido") Produto itemPedido, @Param("pedido") Pedido pedido);

  Long verificaQuantidade(@Param("idProduto") Long idProduto, @Param("idFilial") Long idFilial);

  void insereProdutosEstoque(@Param("tipoPedido") String tipoPedido, @Param("idFilial") Long idFilial, @Param("produtos") Collection<Produto> produtos);
}