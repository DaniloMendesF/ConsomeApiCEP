package com.example.demo.service;

import com.example.demo.domain.dto.CepDTO;
import com.example.demo.domain.request.CepRequest;
import org.springframework.web.bind.MethodArgumentNotValidException;

public interface ConectApi {
    CepDTO retrieveData(CepRequest cepRequest);
}
