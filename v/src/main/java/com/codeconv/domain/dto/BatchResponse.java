package com.codeconv.domain.dto;

import lombok.Builder;

@Builder
public record BatchResponse(
        String name,
        Integer sold,
        Integer available) {}
