package com.desafio.itau.controller;

import com.desafio.itau.controller.docs.EstatisticaControllerDocs;
import com.desafio.itau.model.EstatisticaResponse;
import com.desafio.itau.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class EstatisticaController implements EstatisticaControllerDocs {

    @Autowired
    private TransacaoService service;

    @GetMapping(value = "/estatistica", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EstatisticaResponse> estatisticaTransacao() {
        return ResponseEntity.status(HttpStatus.OK).body(service.estatisticaTransacao());
    }
}
