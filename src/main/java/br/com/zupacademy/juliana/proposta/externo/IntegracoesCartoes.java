package br.com.zupacademy.juliana.proposta.externo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(url = "${proposta.services.sistema-cartao.host}:${proposta" +
        ".services.sistema-cartao.port}", name =
        "integracoesCartoes")
public interface IntegracoesCartoes {

    @PostMapping(value = "/api/cartoes")
    NovoCartaoResponse buscaNumeroCartao(NovoDocumentoRequest request);
}


