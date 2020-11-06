package br.com.ithappens.mapper;

import br.com.ithappens.model.Filial;
import br.com.ithappens.model.ItemPedidoEstoque;
import br.com.ithappens.model.Pedido;
import br.com.ithappens.model.Produto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.Collection;

@Mapper
@Repository
public interface PedidoMapper {

    void novoPedido(Pedido pedido);

    Collection<Pedido> listPedidos();

    void insertItensPedido(@Param("itensPedido") Collection<Produto> itensPedido, @Param("idPedido") Long idPedido) throws SQLException;
}
