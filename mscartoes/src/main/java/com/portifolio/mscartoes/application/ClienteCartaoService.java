package com.portifolio.mscartoes.application;

import com.portifolio.mscartoes.domain.ClienteCartao;
import com.portifolio.mscartoes.infra.repository.ClienteCartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteCartaoService {

    private final ClienteCartaoRepository repository;

    public List<ClienteCartao> listaCartoesByCpf(String cpf) {
        return repository.findByCpf(cpf);
    }
}
