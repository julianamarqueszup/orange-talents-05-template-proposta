package br.com.zupacademy.juliana.proposta.criabiometria;

import br.com.zupacademy.juliana.proposta.associacartao.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoRepository extends JpaRepository<Cartao, Long> {
}