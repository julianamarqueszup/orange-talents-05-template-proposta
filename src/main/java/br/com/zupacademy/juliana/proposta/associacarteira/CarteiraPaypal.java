package br.com.zupacademy.juliana.proposta.associacarteira;

import br.com.zupacademy.juliana.proposta.associacartao.Cartao;

import javax.persistence.*;

@Entity
public class CarteiraPaypal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Cartao cartao;
    private String email;

    @Deprecated
    public CarteiraPaypal() {
    }

    public CarteiraPaypal(Cartao cartao, String email) {
        this.cartao = cartao;
        this.email = email;
    }

    public Long getId() {
        return id;
    }
}