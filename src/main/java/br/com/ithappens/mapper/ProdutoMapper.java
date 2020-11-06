package br.com.ithappens.mapper;

import br.com.ithappens.model.Produto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Mapper
@Repository
public interface ProdutoMapper {

    void insert(Produto produto);

    void bulkInsert(@Param("produtos") Collection<Produto> produtos);

    Produto findByDescription(@Param("description") String description);

    Produto findById(@Param("id") Long id);

    Collection<Produto> findAll();

    void update(Produto produto);

}
