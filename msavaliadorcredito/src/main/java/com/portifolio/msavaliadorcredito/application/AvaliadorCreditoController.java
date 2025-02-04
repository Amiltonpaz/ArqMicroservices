package com.portifolio.msavaliadorcredito.application;

import com.portifolio.msavaliadorcredito.application.exception.DadosClienteNotFoundException;
import com.portifolio.msavaliadorcredito.application.exception.ErroComunicacaoMicroservicesException;
import com.portifolio.msavaliadorcredito.application.exception.ErroSolicitacaoCartaoException;
import com.portifolio.msavaliadorcredito.domain.model.DadosAvaliacao;
import com.portifolio.msavaliadorcredito.domain.model.DadosSolicitacaoEmissaoCartao;
import com.portifolio.msavaliadorcredito.domain.model.RetornoAvalicaoCliente;
import com.portifolio.msavaliadorcredito.domain.model.SituacaoCliente;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("avaliacoes-credito")public class AvaliadorCreditoController {

    private final AvaliadorCreditoService avaliadorCreditoService;

    @GetMapping
    public String  status() {
        return "ok";
    }

    @GetMapping(value = "situacao-cliente", params = "cpf")
    public ResponseEntity consultaSituacaoCliente(@RequestParam String cpf) {

        try {
            SituacaoCliente situacaoCliente = avaliadorCreditoService.obterSituacaoCliente(cpf);
            return ResponseEntity.ok(situacaoCliente);

        } catch (DadosClienteNotFoundException e) {
            return ResponseEntity.notFound().build();

        }catch (ErroComunicacaoMicroservicesException e) {
            return ResponseEntity.status(HttpStatus.resolve(e.getStatus())).body(e.getMessage());
        }

    }

    @PostMapping
    public ResponseEntity realizarAvaliacao(@RequestBody DadosAvaliacao dados) {

        try {
            RetornoAvalicaoCliente retornoAvalicaoCliente = avaliadorCreditoService.realizarAvaliacao(dados.getCpf(), dados.getRenda());
            return ResponseEntity.ok(retornoAvalicaoCliente);

        } catch (DadosClienteNotFoundException e) {
            return ResponseEntity.notFound().build();

        }catch (ErroComunicacaoMicroservicesException e) {
            return ResponseEntity.status(HttpStatus.resolve(e.getStatus())).body(e.getMessage());
        }
    }

    @PostMapping("solicitacoes-cartao")
    public ResponseEntity solicitarCartao(@RequestBody DadosSolicitacaoEmissaoCartao dados) {
        try {
            return ResponseEntity.ok(avaliadorCreditoService.solicitarEmissaoCartao(dados));
        }catch(ErroSolicitacaoCartaoException e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
