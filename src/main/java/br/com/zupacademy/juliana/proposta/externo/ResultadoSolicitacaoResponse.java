package br.com.zupacademy.juliana.proposta.externo;

import br.com.zupacademy.juliana.proposta.criacaoproposta.StatusAvaliacaoResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultadoSolicitacaoResponse {
    @JsonProperty("resultadoSolicitacao")
    private StatusAvaliacaoResponse resultadoAvaliacao;

    @Deprecated
    public ResultadoSolicitacaoResponse() {
    }

    public StatusAvaliacaoResponse getResultadoAvaliacao() {
        return resultadoAvaliacao;
    }
}