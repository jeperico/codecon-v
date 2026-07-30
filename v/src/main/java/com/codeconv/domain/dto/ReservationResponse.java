package com.codeconv.domain.dto;

import java.util.UUID;

import lombok.Builder;

@Builder
public record ReservationResponse(UUID id, String cpf, Integer quantity, String status) {}
