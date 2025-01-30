package com.portifolio.msclientes.application;

import com.portifolio.msclientes.application.representation.ClienteSaveRequest;
import com.portifolio.msclientes.domain.Cliente;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("clientes")
@RequiredArgsConstructor
public class ClientesController {

    private final ClienteService service;

    @GetMapping
    public String status() {
        return "ok";
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ClienteSaveRequest request) {
        Cliente cliente = request.toModel();
        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(cliente.getCpf()).toUri();
        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping(params = "cpf")
    public ResponseEntity dadosCliente(@RequestParam String cpf) {
        Optional<Cliente> optionalCliente = service.getByCpf(cpf);

        if(optionalCliente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optionalCliente);
    }

    @RequestMapping("/rotaDeFallback")
    public Mono<String> fallback() {
        return Mono.just("Serviço temporariamente indisponível. Por favor, tente novamente mais tarde.");
    }

}
