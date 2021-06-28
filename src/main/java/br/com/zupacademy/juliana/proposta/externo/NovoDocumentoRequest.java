package br.com.zupacademy.juliana.proposta.externo;

import br.com.zupacademy.juliana.proposta.criacaoproposta.CPForCNPJ;
import br.com.zupacademy.juliana.proposta.criacaoproposta.Proposta;

public class NovoDocumentoRequest {

    @CPForCNPJ
    private String documento;

    @Deprecated
    public NovoDocumentoRequest() {

    }

    public NovoDocumentoRequest(Proposta proposta) {
        this.documento = proposta.getDocumento();
    }

    public String getDocumento() {
        return documento;
    }
}