package org.expansaojava.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDto {

    private Long id;
    private Long idLoja;
    private String marca;
    private String modelo;
    private String descricao;
    private BigDecimal preco;

}
