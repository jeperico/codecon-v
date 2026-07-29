package com.codeconv.domain.service;


import com.codeconv.domain.dto.CreateReservationRequest;
import com.codeconv.domain.dto.ReservationResponse;
import com.codeconv.domain.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationResponse createReservation(CreateReservationRequest request) {
        return ReservationResponse.builder()
                .id(UUID.randomUUID())
                .cpf(request.getCpf())
                .quantity(request.getQuantity())
                .status("SOLD")
                .build();
    }
}
