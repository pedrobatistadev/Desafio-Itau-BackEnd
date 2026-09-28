package com.desafio.itau.controller.docs;

import com.desafio.itau.model.TransacaoRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface TransacaoControllerDocs {

    @Operation(summary = "Criar Transação", description = "Criar Transação", tags = {"Transação"}, responses = {
            @ApiResponse(description = "Created ", responseCode = "201"),
            @ApiResponse(description = "Unprocessable Entity", responseCode = "422"),
            @ApiResponse(description = "Bad Request", responseCode = "400")})
    ResponseEntity<?> criarTransacao(@Valid @RequestBody TransacaoRequest transacaoRequest);

    @Operation(summary = "Deletar Transações", description = "Deletar Transações", tags = {"Transação"}, responses = {
            @ApiResponse(description = "OK", responseCode = "200")})
    ResponseEntity<?> deleteTransacao();
}
