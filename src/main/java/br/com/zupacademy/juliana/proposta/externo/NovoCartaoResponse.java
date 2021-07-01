package br.com.zupacademy.juliana.proposta.externo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NovoCartaoResponse {
    @JsonProperty("id")
    private String id;

    @Deprecated
    public NovoCartaoResponse() {
    }

    public String getId() {
        return id;
    }
}

