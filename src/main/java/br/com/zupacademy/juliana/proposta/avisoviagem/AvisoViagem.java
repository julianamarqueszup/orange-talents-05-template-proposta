package br.com.zupacademy.juliana.proposta.avisoviagem;

import br.com.zupacademy.juliana.proposta.associacartao.Cartao;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.time.OffsetDateTime;

@Entity
public class AvisoViagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @NotNull
    private Cartao cartao;
    @NotBlank
    private String destino;
    @NotNull
    private LocalDate dataTermino;
    @NotBlank
    private String navegador;
    @NotBlank
    private String remoteAddr;
    @NotNull
    @PastOrPresent
    private OffsetDateTime instante = OffsetDateTime.now();

    public AvisoViagem(Cartao cartao, NovoAvisoViagemRequest request, String navegador, String remoteAddr) {
        this.cartao = cartao;
        this.destino = request.getDestino();
        this.dataTermino = request.getValidoAte();
        this.navegador = navegador;
        this.remoteAddr = remoteAddr;
    }

    public Long getId() {
        return id;
    }
}