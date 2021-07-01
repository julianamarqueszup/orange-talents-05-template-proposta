package br.com.zupacademy.juliana.proposta.avisoviagem;

import br.com.zupacademy.juliana.proposta.associacartao.Cartao;
import br.com.zupacademy.juliana.proposta.criabiometria.CartaoRepository;
import br.com.zupacademy.juliana.proposta.exception.NegocioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class AvisoViagemController {

    @Autowired
    private CartaoRepository cartaoRepository;
    @Autowired
    private EntityManager manager;

    @PostMapping("/api/cartoes/{id}/aviso-viagem")
    @Transactional
    public ResponseEntity<?> avisa(@PathVariable("id") Long id,
                                   @RequestBody @Valid NovoAvisoViagemRequest request,
                                   @RequestHeader(HttpHeaders.USER_AGENT) String navegador,
                                   HttpServletRequest httpRequest,
                                   UriComponentsBuilder uriComponentsBuilder) {
        Cartao cartao = cartaoRepository.findById(id).orElseThrow(() -> new NegocioException(
                "Cartão não encontrado. id: " + id, HttpStatus.NOT_FOUND));

        if (cartao.isBloqueado()){
            throw new NegocioException("Cartão bloqueado. Não é possível " +
                    "solicitar aviso de viagem",
                    HttpStatus.BAD_REQUEST);
        }

        AvisoViagem avisoViagem = new AvisoViagem(cartao,
                request, navegador,
                httpRequest.getRemoteAddr());

        List dataTermino = manager.createQuery("SELECT 1 FROM AvisoViagem av" +
                " WHERE av" +
                ".dataTermino like :dataTermino").setParameter(
                "dataTermino",
                request.getDataTermino()).getResultList();

        if (!dataTermino.isEmpty()){
            throw new NegocioException("Aviso já cadastrado",
                    HttpStatus.BAD_REQUEST);
        }

        manager.persist(avisoViagem);

        URI uri = uriComponentsBuilder.path("/api/avisos/{id}").build(avisoViagem.getId());
        return ResponseEntity.created(uri).build();
    }
}