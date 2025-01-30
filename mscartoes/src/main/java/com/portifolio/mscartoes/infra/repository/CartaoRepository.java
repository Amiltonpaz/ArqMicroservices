package com.portifolio.mscartoes.infra.repository;

import com.portifolio.mscartoes.domain.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoRepository extends JpaRepository<Cartao,Long> {
}
