package com.desafio.itau.controller;

import com.desafio.itau.controller.docs.TransacaoControllerDocs;
import com.desafio.itau.model.TransacaoRequest;
import com.desafio.itau.model.EstatisticaResponse;
import com.desafio.itau.service.TransacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class TransacaoController implements TransacaoControllerDocs {

    @Autowired
    private TransacaoService service;

    @PostMapping(value = "/transacao")
    public ResponseEntity<?> criarTransacao(@Valid @RequestBody TransacaoRequest transacaoRequest) {
        service.criarTransacao(transacaoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/estatistica", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EstatisticaResponse> estatisticaTransacao() {
        return ResponseEntity.status(HttpStatus.OK).body(service.estatisticaTransacao());
    }

    @DeleteMapping(value = "/transacao")
    public ResponseEntity<?> deleteTransacao() {
        service.deleteTransacao();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
