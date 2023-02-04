package com.example.demo.service;

import com.example.demo.config.exception.CepNotFoundException;
import com.example.demo.domain.dto.CepDTO;
import com.example.demo.domain.request.CepRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConectApimpl implements ConectApi{

  @Autowired
  private RestTemplate restTemplate;

    @Override
    public CepDTO retrieveData(CepRequest cepRequest) {

      CepDTO cepDTO = new CepDTO();
      cepDTO = restTemplate.getForEntity("https://viacep.com.br/ws/"+cepRequest.getCep()+"/json/",CepDTO.class).getBody();

      if (cepDTO.getCep() == null){
        throw new CepNotFoundException("CEP não cadastrado na API Externa");
      }
      return cepDTO;
    }
}
