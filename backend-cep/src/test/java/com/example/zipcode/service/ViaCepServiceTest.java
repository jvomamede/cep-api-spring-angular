package com.example.zipcode.service;

import com.example.zipcode.model.ResponseAddress;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ViaCepServiceTest {

    @Autowired
    private ViaCepService viaCepService;

    @Test
    public void ViaCepTestCepValidate() {
        ResponseAddress address = this.viaCepService.getAddressByCep("01001000");
        assertEquals("Praça da Sé", address.getLogradouro());
        assertEquals("01001-000", address.getCep());
        assertEquals("lado ímpar", address.getComplemento());
        assertEquals("Sé", address.getBairro());
        assertEquals("São Paulo", address.getLocalidade());
        assertEquals("SP", address.getUf());
        assertEquals("3550308", address.getIbge());
        assertEquals("1004", address.getGia());
        assertEquals("11", address.getDdd());
        assertEquals("7107", address.getSiafi());
    }

}
