package com.codeconv.common.dto;

import lombok.Builder;

@Builder
public record ErrorResponse(String message) {}
