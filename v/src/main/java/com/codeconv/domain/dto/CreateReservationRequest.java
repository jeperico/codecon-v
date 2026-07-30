package com.codeconv.domain.dto;

import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateReservationRequest {

    @NotBlank
    private String cpf;

    @NotBlank
    private Integer quantity;
}
