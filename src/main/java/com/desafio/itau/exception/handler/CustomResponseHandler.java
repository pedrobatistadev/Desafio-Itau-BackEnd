package com.desafio.itau.exception.handler;

import com.desafio.itau.exception.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.text.SimpleDateFormat;
import java.util.Date;

@ControllerAdvice
@RestController
public class CustomResponseHandler {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handlerAllException(Exception ex, WebRequest request) {
        String data = sdf.format(new Date());
        ExceptionResponse response = new ExceptionResponse(ex.getMessage(),request.getDescription(false), data);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<ExceptionResponse> handlerUnprocessableEntityException(Exception ex, WebRequest request) {
        String data = sdf.format(new Date());
        ExceptionResponse response = new ExceptionResponse("A transação não foi aceita por qualquer motivo (1 ou mais dos critérios de aceite não foram atendidos - por exemplo: uma transação com valor menor que 0)",request.getDescription(false), data);

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).body(response);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public final ResponseEntity<ExceptionResponse> handlerBadRequestException(Exception ex, WebRequest request) {
        String data = sdf.format(new Date());
        ExceptionResponse response = new ExceptionResponse("A API não compreendeu a requisição (por exemplo: um JSON inválido)",request.getDescription(false), data);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
