package com.codeconv.domain.dto;

import lombok.Builder;

@Builder
public record BatchResponse(Integer total, Integer sold, Integer available) {}
