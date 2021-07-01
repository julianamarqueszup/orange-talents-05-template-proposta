package br.com.zupacademy.juliana.proposta.criacaoproposta;

public enum StatusAvaliacaoResponse {
    COM_RESTRICAO(StatusAvaliacaoProposta.NAO_ELEGIVEL), SEM_RESTRICAO(StatusAvaliacaoProposta.ELEGIVEL);

    private StatusAvaliacaoProposta statusAvaliacaoProposta;


    StatusAvaliacaoResponse(StatusAvaliacaoProposta statusAvaliacaoProposta) {
        this.statusAvaliacaoProposta = statusAvaliacaoProposta;
    }

    public StatusAvaliacaoProposta getStatusAvaliacaoProposta() {
        return statusAvaliacaoProposta;
    }
}

