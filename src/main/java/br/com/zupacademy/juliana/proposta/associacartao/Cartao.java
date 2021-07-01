package br.com.zupacademy.juliana.proposta.associacartao;


import br.com.zupacademy.juliana.proposta.criacaoproposta.Proposta;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Cartao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Proposta proposta;
    @NotBlank
    private String numero;

    @Deprecated
    public Cartao() {
    }

    public Cartao(@NotNull @Valid Proposta proposta,
                  @NotBlank String numero) {
        this.proposta = proposta;
        this.numero = numero;
    }
}

