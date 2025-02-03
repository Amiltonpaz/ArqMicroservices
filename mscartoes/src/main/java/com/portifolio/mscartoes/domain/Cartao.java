package com.portifolio.mscartoes.domain;

import com.portifolio.mscartoes.application.representation.CartaoSaveRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Enumerated(EnumType.STRING)
    private BandeiraCartao bandeira;
    private BigDecimal renda;
    private BigDecimal limiteBasico;

    public Cartao(CartaoSaveRequest cartaoSaveRequest) {

        this.nome = cartaoSaveRequest.getNome();
        this.bandeira = cartaoSaveRequest.getBandeira();
        this.renda = cartaoSaveRequest.getRenda();
        this.limiteBasico = cartaoSaveRequest.getLimiteBasico();

    }

    public Cartao(String nome, BandeiraCartao bandeira, BigDecimal renda, BigDecimal limiteBasico) {
        this.nome = nome;
        this.bandeira = bandeira;
        this.renda = renda;
        this.limiteBasico = limiteBasico;
    }
}
