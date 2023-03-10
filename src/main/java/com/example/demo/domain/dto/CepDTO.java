package com.example.demo.domain.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CepDTO {

    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
}
