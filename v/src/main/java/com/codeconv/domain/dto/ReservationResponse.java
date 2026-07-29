package com.codeconv.domain.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record ReservationResponse(
        UUID id,
        String cpf,
        Integer quantity,
        String status) {}
