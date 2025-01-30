package com.portifolio.mscloudgateway.application;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallBackController {

    @RequestMapping("/rotaDeFallback")
    public ResponseEntity<Mono<String>> fallback() {
        return ResponseEntity.internalServerError()
                .body(Mono.just("Serviço temporariamente indisponível. Por favor, tente novamente mais tarde."));
    }

}
