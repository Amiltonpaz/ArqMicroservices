package com.portifolio.mscartoes.application;

import com.portifolio.mscartoes.application.resource.CartaoSaveRequest;
import com.portifolio.mscartoes.domain.Cartao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("cartoes")
public class CartoesResource {

    @GetMapping
    public String status() {
        return new String("ok");
    }

    @PostMapping
    public ResponseEntity cadastraCartoes(@RequestBody CartaoSaveRequest cartaoRequest) {
        Cartao cartao = cartaoRequest.toModel(cartaoRequest);

        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("id = {id}")
                .buildAndExpand(cartao.getId()).toUri();
        return ResponseEntity.created(headerLocation).build();
    }
}
