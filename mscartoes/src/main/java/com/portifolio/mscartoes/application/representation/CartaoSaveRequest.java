package com.portifolio.mscartoes.application.representation;

import com.portifolio.mscartoes.domain.BandeiraCartao;
import com.portifolio.mscartoes.domain.Cartao;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartaoSaveRequest {

    private String nome;
    private BandeiraCartao bandeira;
    private BigDecimal renda;
    private BigDecimal limiteBasico;

    public Cartao toModel(CartaoSaveRequest cartaoSaveRequest) {
        return new Cartao(cartaoSaveRequest);
    }
}
