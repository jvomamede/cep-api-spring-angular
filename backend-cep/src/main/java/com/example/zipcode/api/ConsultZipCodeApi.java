package com.example.zipcode.api;

import com.example.zipcode.model.ResponseAddress;
import com.example.zipcode.model.RequestCep;

import com.example.zipcode.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/consult-zipcode")
public class ConsultZipCodeApi  {

    @Autowired
    private ViaCepService viaCepService;

    @PostMapping
    public ResponseEntity<ResponseAddress> getAddress(@Valid @RequestBody RequestCep requestCep)  {
       ResponseAddress address = this.viaCepService.getAddressByCep(requestCep.getCep());
       return ResponseEntity.status(HttpStatus.OK).body(address);
    }
    
}
