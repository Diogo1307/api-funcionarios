package com.example.funcionarioapi.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        List<String> erros = new ArrayList<>();

        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            erros.add(fieldError.getField() + ": " + fieldError.getDefaultMessage());
        }

        for (ObjectError globalError : ex.getBindingResult().getGlobalErrors()) {
            erros.add(globalError.getObjectName() + ": " + globalError.getDefaultMessage());
        }

        ErroResposta erroResposta = new ErroResposta(
                status.value(),
                "Erros de validação",
                LocalDateTime.now(),
                erros
        );

        return handleExceptionInternal(ex, erroResposta, headers, status, request);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        List<String> erros = List.of(ex.getMessage());

        ErroResposta erroResposta = new ErroResposta(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Erro interno do servidor",
                LocalDateTime.now(),
                erros
        );

        return new ResponseEntity<>(erroResposta, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
