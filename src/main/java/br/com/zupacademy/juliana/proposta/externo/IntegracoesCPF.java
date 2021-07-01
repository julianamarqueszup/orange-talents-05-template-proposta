package br.com.zupacademy.juliana.proposta.externo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(url = "${proposta.services.analise-financeira.host}:${proposta" +
        ".services.analise-financeira.port}", name =
        "integracoesCPF")
public interface IntegracoesCPF {

    @PostMapping(value = "/api/solicitacao")
    public ResultadoSolicitacaoResponse avalia(NovoDocumentoRequest request);

}

