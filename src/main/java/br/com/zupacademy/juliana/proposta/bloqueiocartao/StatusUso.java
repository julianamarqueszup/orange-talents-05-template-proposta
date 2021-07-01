package br.com.zupacademy.juliana.proposta.bloqueiocartao;

import br.com.zupacademy.juliana.proposta.associacartao.Cartao;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.OffsetDateTime;

@Entity
public class StatusUso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private PossiveisStatusUso statusSolicitado;
    @ManyToOne
    private Cartao cartao;
    @NotBlank
    private String userAgent;
    @NotBlank
    private String ipRemoto;
    private OffsetDateTime timestamp = OffsetDateTime.now();

    @Deprecated
    public StatusUso() {
    }

    public StatusUso(PossiveisStatusUso bloqueado, Cartao cartao,
                     @NotBlank String userAgent, @NotBlank String ipRemoto) {
        statusSolicitado = bloqueado;
        this.cartao = cartao;
        this.userAgent = userAgent;
        this.ipRemoto = ipRemoto;
    }

    public PossiveisStatusUso getStatusSolicitado() {
        return statusSolicitado;
    }
}