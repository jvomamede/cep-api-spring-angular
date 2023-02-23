package com.example.zipcode.service;


import com.example.zipcode.model.ResponseAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ViaCepService {

    @Value("${url.viacep}")
    private String URL_BASE;

    public ResponseAddress getAddressByCep(String cep) {
        String url = URL_BASE + cep + "/json";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, ResponseAddress.class);
    }


}
