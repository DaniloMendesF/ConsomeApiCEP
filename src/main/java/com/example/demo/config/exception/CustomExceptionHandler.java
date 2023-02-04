package com.example.demo.config.exception;

import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CepNotFoundException.class)
    public ResponseEntity<Object> handleCepNotFoundException(CepNotFoundException exception, WebRequest request){

        ApiErrorMessage apiErrorMessage = new ApiErrorMessage(new Date(), HttpStatus.NOT_FOUND.value() ,HttpStatus.NOT_FOUND, exception.getMessage());
        return new ResponseEntity<>(apiErrorMessage, apiErrorMessage.getStatusCode());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        ApiErrorMessage apiErrorMessage = new ApiErrorMessage(new Date(), status.value(),status, errors);
        return new ResponseEntity<>(apiErrorMessage, apiErrorMessage.getStatusCode());
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String errors = "Requisição necessita do body para efetuar a consulta";

        ApiErrorMessage apiErrorMessage = new ApiErrorMessage(new Date(), status.value(),status, errors);
        return new ResponseEntity<>(apiErrorMessage, apiErrorMessage.getStatusCode());
    }
}
