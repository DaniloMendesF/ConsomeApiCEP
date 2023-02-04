package com.example.demo.config.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ApiErrorMessage {

    private Date data;
    private int status;
    private HttpStatusCode statusCode;
    private List<String> erros;

    public ApiErrorMessage(Date data, int status, HttpStatusCode statusCode, List<String> erros) {
        this.data = data;
        this.status = status;
        this.statusCode = statusCode;
        this.erros = erros;
    }

    public ApiErrorMessage(Date data, int status, HttpStatusCode statusCode, String erros) {
        this.data = data;
        this.status = status;
        this.statusCode = statusCode;
        this.erros = Arrays.asList(erros);
    }
}
