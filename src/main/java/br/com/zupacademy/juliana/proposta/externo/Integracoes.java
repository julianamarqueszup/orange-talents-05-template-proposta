package br.com.zupacademy.juliana.proposta.externo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(url = "localhost:9999/api",  name = "integracoes")
public interface Integracoes {

    @PostMapping("/solicitacao")
    public ResultadoSolicitacaoResponse avalia(NovoDocumentoRequest request);

}