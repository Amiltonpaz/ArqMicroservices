package com.portifolio.msclientes.infra.repository;

import com.portifolio.msclientes.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByCpf(String cpf);
}
