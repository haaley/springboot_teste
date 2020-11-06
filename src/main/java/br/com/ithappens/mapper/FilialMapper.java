package br.com.ithappens.mapper;

import br.com.ithappens.model.Filial;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.Collection;

@Mapper
@Repository
public interface FilialMapper {

    Filial findById(Long id);

    void insert(Filial filial);

    Collection<Filial> findByDescription(@Param("descricao") String descricao);

    Collection<Filial> findAll();

    void update(Filial filial) throws SQLException;

}
