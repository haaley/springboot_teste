package br.com.ithappens.service;

import br.com.ithappens.mapper.FilialMapper;
import br.com.ithappens.mapper.ProdutoMapper;
import br.com.ithappens.model.Filial;
import br.com.ithappens.model.Produto;
import br.com.ithappens.model.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Optional;

@Service
public class FilialService {

    private final FilialMapper filialMapper;

    @Autowired
    public FilialService(FilialMapper filialMapper) {
        this.filialMapper = filialMapper;
    }

    public void cadastrarFilial(Filial filial) {
        try {
            filialMapper.insert(filial);
        } catch (Exception e) {
            throw e;
        }
    }

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

    public Filial getFilial(Long id) throws ResourceNotFoundException {
        Optional<Filial> filial = Optional.ofNullable(filialMapper.findById(id));
        return filial.orElseThrow(() -> new ResourceNotFoundException("Filial não encontrada"));
    }

    public boolean updateFilial(Filial filial) throws SQLException {
        try {
            filialMapper.update(filial);
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    public Collection<Filial> findByDescription(String description) {
        try {
            return filialMapper.findByDescription(description);
        } catch (Exception e) {
            throw e;
        }
    }
}
