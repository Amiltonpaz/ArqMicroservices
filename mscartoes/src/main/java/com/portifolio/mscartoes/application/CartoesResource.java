package com.portifolio.mscartoes.application;

import com.portifolio.mscartoes.application.representation.CartaoSaveRequest;
import com.portifolio.mscartoes.application.representation.CartoesPorClienteResponse;
import com.portifolio.mscartoes.domain.Cartao;
import com.portifolio.mscartoes.domain.ClienteCartao;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("cartoes")
@RequiredArgsConstructor
public class CartoesResource {

    private final CartaoService service;

    private final ClienteCartaoService clienteCartaoService;

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

    @GetMapping(params = "renda")
    public ResponseEntity<List<Cartao>> getCartoesRendaAte(@RequestParam Long renda) {
        List<Cartao> list = service.getCartoesRendaMenorIguel(renda);
        return ResponseEntity.ok(list);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<CartoesPorClienteResponse>> getCartoesByCliente(@RequestParam String cpf) {
        List<ClienteCartao> lista = clienteCartaoService.listaCartoesByCpf(cpf);
        return ResponseEntity.ok().body(lista.stream().map(CartoesPorClienteResponse::fromModel)
                .toList());
    }

}
