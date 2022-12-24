package org.expansaojava.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LojaDto {

    private String nome;
    private String endereco;
    private String telefone;
}
