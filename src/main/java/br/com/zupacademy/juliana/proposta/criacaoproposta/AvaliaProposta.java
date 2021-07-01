package br.com.zupacademy.juliana.proposta.criacaoproposta;
import br.com.zupacademy.juliana.proposta.externo.Integracoes;
import br.com.zupacademy.juliana.proposta.externo.NovoDocumentoRequest;

import br.com.zupacademy.juliana.proposta.externo.ResultadoSolicitacaoResponse;
import feign.RetryableException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;



@Service
@Validated
public class AvaliaProposta {
    @Autowired
    private Integracoes integracoes;

    public StatusAvaliacaoProposta executa(@NotNull @Validated Proposta proposta) throws RetryableException {

        ResultadoSolicitacaoResponse resultadoAvaliacao =
                integracoes.avalia(new NovoDocumentoRequest(proposta));
        return StatusAvaliacaoResponse
                .valueOf(resultadoAvaliacao.getResultadoAvaliacao()
                        .name()).getStatusAvaliacaoProposta();


    }
}