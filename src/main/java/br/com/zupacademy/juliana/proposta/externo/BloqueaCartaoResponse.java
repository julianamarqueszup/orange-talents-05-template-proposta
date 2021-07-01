package br.com.zupacademy.juliana.proposta.externo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BloqueaCartaoResponse {
    @JsonProperty
    private String resultado;

    @Deprecated
    public BloqueaCartaoResponse() {
    }
}