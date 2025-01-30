package com.portifolio.mscartoes.application;

import com.portifolio.mscartoes.domain.Cartao;
import com.portifolio.mscartoes.infra.repository.CartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartaoService {

    private final CartaoRepository repository;


    public Cartao createCartao(Cartao cartao) {
        return repository.save(cartao);
    }

}
