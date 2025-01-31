package com.portifolio.msavaliadorcredito.application;

import com.portifolio.msavaliadorcredito.domain.model.SituacaoCliente;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AvaliadorCreditoService {

    public SituacaoCliente obterSituacaoCliente(String cpf) {
        //obter dados do cliente - MSCLIENTES
        //obrwe cartões do cliente - MSCARTOES
        return null;
    }

}
