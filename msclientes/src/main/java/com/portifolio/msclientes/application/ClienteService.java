package com.portifolio.msclientes.application;

import com.portifolio.msclientes.infra.repository.ClienteRepository;
import com.portifolio.msclientes.domain.Cliente;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;

    @Transactional
    public Cliente save(Cliente cliente) {
        return repository.save(cliente);
    }

    @Cacheable("clientes")
    public Optional<Cliente> getByCpf(String cpf) {
        System.out.println("Buscando...");
        return repository.findByCpf(cpf);
    }


}
