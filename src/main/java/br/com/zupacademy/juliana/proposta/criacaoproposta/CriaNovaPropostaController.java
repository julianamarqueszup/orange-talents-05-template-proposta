package br.com.zupacademy.juliana.proposta.criacaoproposta;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;


@RestController
public class CriaNovaPropostaController {


    @PostMapping(value = "/api/propostas")
    @Transactional
    public ResponseEntity<?> cria(
            @RequestBody @Valid NovaPropostaRequest request,
            UriComponentsBuilder builder) {

    }
}