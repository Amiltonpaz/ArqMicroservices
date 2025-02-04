package com.portifolio.mscartoes.infra.mq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.portifolio.mscartoes.domain.Cartao;
import com.portifolio.mscartoes.domain.ClienteCartao;
import com.portifolio.mscartoes.domain.DadosSolicitacaoEmissaoCartao;
import com.portifolio.mscartoes.infra.repository.CartaoRepository;
import com.portifolio.mscartoes.infra.repository.ClienteCartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmissaoCartaoSubscriber {

    private final CartaoRepository cartaoRepository;
    private final ClienteCartaoRepository clienteCartaoRepository;

    @RabbitListener(queues = "${mq.queues.emitir-cartao}")
    public void receberSolicitacaoEmissoa(@Payload String payload) {
        var mapper = new ObjectMapper();

        try {
            DadosSolicitacaoEmissaoCartao dadosSolicitacaoEmissaoCartao = mapper.readValue(payload, DadosSolicitacaoEmissaoCartao.class);
            Cartao cartaoEmitido = cartaoRepository.findById(dadosSolicitacaoEmissaoCartao.getIdCartao()).orElseThrow();

            ClienteCartao clienteCartao = new ClienteCartao();
            clienteCartao.setCartao(cartaoEmitido);
            clienteCartao.setCpf(dadosSolicitacaoEmissaoCartao.getCpf());
            clienteCartao.setLimite(dadosSolicitacaoEmissaoCartao.getLimiteLiberado());

            clienteCartaoRepository.save(clienteCartao);

        }catch(JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
