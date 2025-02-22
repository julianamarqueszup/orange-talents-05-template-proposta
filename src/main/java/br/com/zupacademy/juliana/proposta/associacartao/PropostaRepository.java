package br.com.zupacademy.juliana.proposta.associacartao;

import br.com.zupacademy.juliana.proposta.criacaoproposta.Proposta;
import br.com.zupacademy.juliana.proposta.criacaoproposta.StatusAvaliacaoProposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta, Long> {
    @Query("SELECT p FROM Proposta p left join p.cartao c WHERE p" +
            ".statusAvaliacao = :status and c.id is null")
    List<Proposta> todasSemCartao(@Param("status") StatusAvaliacaoProposta elegivel);
}
