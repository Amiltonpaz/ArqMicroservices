package com.portifolio.msavaliadorcredito.domain.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartaoAprovado {
    private String nome;
    private String bandeira;
    private BigDecimal limiteLiberado;
}
