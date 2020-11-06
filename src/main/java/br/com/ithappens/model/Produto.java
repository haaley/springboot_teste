package br.com.ithappens.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Produto {

    private Long idProduto;
    private String descricao;
    private Long quantidade;

}
