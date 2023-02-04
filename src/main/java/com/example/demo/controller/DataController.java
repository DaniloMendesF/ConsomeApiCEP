package com.example.demo.controller;

import com.example.demo.domain.dto.CepDTO;
import com.example.demo.domain.request.CepRequest;
import com.example.demo.service.ConectApi;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {

    private final ConectApi conectApi;

    public DataController(ConectApi conectApi) {
        this.conectApi = conectApi;
    }

    @ResponseBody
    @GetMapping("/data")
    public ResponseEntity<CepDTO> retrieveData(@Valid @RequestBody CepRequest cepRequest){

        CepDTO cepDTO = conectApi.retrieveData(cepRequest);
        return new ResponseEntity<CepDTO>(cepDTO, HttpStatus.OK);
    }
}
