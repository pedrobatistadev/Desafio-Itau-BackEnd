package com.desafio.itau.controller.docs;

import com.desafio.itau.model.EstatisticaResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public interface EstatisticaControllerDocs {

    @Operation(summary = "Gerar Estatística", description = "Gerar Estatística", tags = {"Estatística"}, responses = {
            @ApiResponse(description = "OK", responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))})
    ResponseEntity<EstatisticaResponse> estatisticaTransacao(@RequestParam("tempo") Integer tempo);
}
