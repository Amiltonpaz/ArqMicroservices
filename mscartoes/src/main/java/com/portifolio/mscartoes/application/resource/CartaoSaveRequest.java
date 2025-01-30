package com.portifolio.mscartoes.application.resource;

import com.portifolio.mscartoes.domain.BandeiraCartao;
import com.portifolio.mscartoes.domain.Cartao;

import java.math.BigDecimal;

public class CartaoSaveRequest {

    private String nome;
    private BandeiraCartao bandeira;
    private BigDecimal renda;
    private BigDecimal limiteBasico;

    public Cartao toModel(CartaoSaveRequest cartaoSaveRequest) {
        return new Cartao(cartaoSaveRequest);
    }
}
