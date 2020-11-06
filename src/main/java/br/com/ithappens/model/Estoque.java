package br.com.ithappens.model;

import lombok.Data;
import java.util.Set;

@Data
public class Estoque {

    private Long idFilial;
    private Set<Produto> produtos;

}
