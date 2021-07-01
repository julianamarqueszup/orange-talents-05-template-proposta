package br.com.zupacademy.juliana.proposta.externo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BloqueaCartaoRequest {
    @JsonProperty
    private String sistemaResponsavel;

    @Deprecated
    public BloqueaCartaoRequest() {
    }

    public BloqueaCartaoRequest(String sistemaResponsavel) {
        this.sistemaResponsavel = sistemaResponsavel;
    }
}