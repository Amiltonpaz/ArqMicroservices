package com.portifolio.msavaliadorcredito.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class RetornoAvalicaoCliente {
    List<CartaoAprovado> cartoesAprovados;
}
