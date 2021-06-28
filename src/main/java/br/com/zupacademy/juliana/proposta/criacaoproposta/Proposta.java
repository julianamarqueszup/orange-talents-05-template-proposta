package br.com.zupacademy.juliana.proposta.criacaoproposta;

import com.sun.istack.NotNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class Proposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Email
    @NotBlank
    private String email;
    private String nome;
    @NotBlank
    private String endereco;
    @Positive
    private BigDecimal salario;
    @NotBlank
    private String documento;
    @NotNull
    @Enumerated(EnumType.STRING)
    private StatusAvaliacaoProposta statusAvaliacao;


    @Deprecated
    public Proposta() {
    }

    public Proposta(String email,
                    String nome,
                    String endereco,
                    BigDecimal salario,
                    String documento) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodedDocuemento = bCryptPasswordEncoder.encode(documento);
        this.email = email;
        this.nome = nome;
        this.endereco = endereco;
        this.salario = salario;
        this.documento = encodedDocuemento;
        this.statusAvaliacao = StatusAvaliacaoProposta.NAO_ELEGIVEL;
    }

    public Long getId() {
        Assert.notNull(id, "O objeto não possui id.");
        return id;
    }

    public String getDocumento() {
        return documento;
    }

    public StatusAvaliacaoProposta getStatusAvaliacao() {
        return statusAvaliacao;
    }

    public void atualizaStatus(StatusAvaliacaoProposta avaliacao) {
        Assert.isTrue(this.statusAvaliacao.equals(StatusAvaliacaoProposta.NAO_ELEGIVEL), "Não pode mais trocar uma vez que a proposta é elegível.");
        this.statusAvaliacao = avaliacao;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }



}