package com.codeconv.domain.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

import com.codeconv.common.exception.ResourceNotFoundException;
import com.codeconv.domain.dto.CreateReservationRequest;
import com.codeconv.domain.dto.ReservationResponse;
import com.codeconv.domain.entity.Batch;
import com.codeconv.domain.entity.Reservation;
import com.codeconv.domain.repository.BatchRepository;
import com.codeconv.domain.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final BatchRepository batchRepository;

    public ReservationResponse createReservation(CreateReservationRequest request) {
        Batch batch = batchRepository
                .findById(UUID.fromString("11111111-1111-1111-1111-111111111111"))
                .orElseThrow(() -> new ResourceNotFoundException("Wedding not found"));

        Reservation reservation = Reservation.builder()
                .cpf(request.getCpf())
                .quantity(request.getQuantity())
                .status("SOLD")
                .batch(batch)
                .build();

        reservationRepository.save(reservation);

        return ReservationResponse.builder()
                .cpf(request.getCpf())
                .quantity(reservation.getQuantity())
                .status("SOLD")
                .build();
    }
}
