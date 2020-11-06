package br.com.ithappens.service;

import br.com.ithappens.mapper.ProdutoMapper;
import br.com.ithappens.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProdutoService {

    private final ProdutoMapper produtoMapper;

    @Autowired
    public ProdutoService(ProdutoMapper produtoMapper) {
        this.produtoMapper = produtoMapper;
    }

    public void cadastrarProduto(Produto produto) {
        try {
            produtoMapper.insert(produto);
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Produto> listProdutos() {
        try {
            return produtoMapper.findAll();
        } catch (Exception e) {
            throw e;
        }
    }

    public Produto getProduto(Long id) {
        try {
            return produtoMapper.findById(id);
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean updateProduto(Produto produto) {
        try {
            produtoMapper.update(produto);
            return true;
        } catch (Exception e) {
            throw e;
        }
    }
}
