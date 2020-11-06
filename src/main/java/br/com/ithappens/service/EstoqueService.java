package br.com.ithappens.service;

import br.com.ithappens.mapper.EstoqueMapper;
import br.com.ithappens.mapper.FilialMapper;
import br.com.ithappens.model.Estoque;
import br.com.ithappens.model.Filial;
import br.com.ithappens.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class EstoqueService {

    private final EstoqueMapper estoqueMapper;

    @Autowired
    public EstoqueService(EstoqueMapper estoqueMapper) {
        this.estoqueMapper = estoqueMapper;
    }

    public Estoque listarEstoque(Long idFilial) {
        try {
            Set<Produto> produtosEstoque = new HashSet<>(estoqueMapper.findByFilial(idFilial));
            Estoque estoque = new Estoque();
            estoque.setIdFilial(idFilial);
            estoque.setProdutos(produtosEstoque);
            return estoque;
        } catch (Exception e) {
            throw e;
        }
    }
/*
    public Collection<Filial> listFiliais(Optional<String> descricao) {
        try {
            if (descricao.isPresent()) {
                return filialMapper.findByDescription(descricao.get());
            } else {
                return filialMapper.findAll();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public Filial getFilial(Long id) {
        try {
            return filialMapper.findById(id);
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean updateFilial(Filial filial) {
        try {
            filialMapper.update(filial);
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Filial> findByDescription(String description) {
        try {
            return filialMapper.findByDescription(description);
        } catch (Exception e) {
            throw e;
        }
    }*/
}
