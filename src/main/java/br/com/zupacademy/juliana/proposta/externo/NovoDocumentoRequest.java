package br.com.zupacademy.juliana.proposta.externo;

import br.com.zupacademy.juliana.proposta.criacaoproposta.CPForCNPJ;
import br.com.zupacademy.juliana.proposta.criacaoproposta.Proposta;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class NovoDocumentoRequest {

    @CPForCNPJ
    private String documento;

    @Deprecated
    public NovoDocumentoRequest() {

    }

    public NovoDocumentoRequest(Proposta proposta) {
        this.documento = proposta.getDocumento();
    }

}