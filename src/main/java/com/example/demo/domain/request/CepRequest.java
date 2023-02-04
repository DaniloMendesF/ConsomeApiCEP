package com.example.demo.domain.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CepRequest {

    @NotBlank(message = "Valor do cep obrigatório")
    @Length(min = 8, max = 8, message = "Cep deve conter 8 dígitos")
    @Pattern(regexp = "[0-9]+", message = "Cep deve conter apenas números")
    private String cep;
}
