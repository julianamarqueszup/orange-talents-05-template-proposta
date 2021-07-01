package br.com.zupacademy.juliana.proposta.compartilhado;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthContributor;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.net.Socket;

@Component("Api - Análise de crédito")
public class ApiSolicitacaoHealthIndicator implements HealthIndicator, HealthContributor {

    @Value("${proposta.services.analise-financeira.host}:${proposta" +
            ".services.analise-financeira.port}")
    private String url;

    @Override
    public Health health() {
        try (Socket socket =
                     new Socket(new java.net.URL(url+"/api" +
                             "/solicitacao").getHost(),
                             9999)) {
        } catch (Exception e) {
            return Health.down().withDetail("error", e.getMessage()).build();
        }
        return Health.up().build();
    }
}

