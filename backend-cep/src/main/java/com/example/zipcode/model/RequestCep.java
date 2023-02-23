package com.example.zipcode.model;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@Data @Builder
public class RequestCep {

    @NotNull
    @NotEmpty
    @NotBlank
    private String cep;

}
