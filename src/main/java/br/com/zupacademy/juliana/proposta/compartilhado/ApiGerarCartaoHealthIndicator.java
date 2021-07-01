package br.com.zupacademy.juliana.proposta.compartilhado;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.net.Socket;

@Component("Api - Gerar numeração cartão")
public class ApiGerarCartaoHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        try (Socket socket = new Socket(new java.net.URL("https://localhost" +
                ":8888/api/cartoes").getHost(), 8888)) {
        } catch (Exception e) {
            return Health.down().withDetail("error", e.getMessage()).build();
        }
        return Health.up().build();
    }
}
