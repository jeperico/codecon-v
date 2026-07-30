package com.codeconv.domain.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import com.codeconv.common.exception.ResourceNotFoundException;
import com.codeconv.domain.dto.BatchResponse;
import com.codeconv.domain.entity.Batch;
import com.codeconv.domain.entity.Reservation;
import com.codeconv.domain.repository.BatchRepository;
import com.codeconv.domain.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BatchService {

    private final BatchRepository batchRepository;
    private final ReservationRepository reservationRepository;

    private Batch getBatch(UUID id) {
        return batchRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Wedding not found"));
    }

    public BatchResponse viewBatch() {
        Batch batch = getBatch(UUID.fromString("11111111-1111-1111-1111-111111111111"));
        List<Reservation> reservations = reservationRepository.findByBatchIdAndIsActiveTrue(batch.getId());

        int total = batch.getTotal();
        int sold = reservations.size();
        int available = total - sold;

        return BatchResponse.builder()
                .total(total)
                .sold(sold)
                .available(available)
                .build();
    }

    public BatchResponse resetBatch() {
        Batch batch = getBatch(UUID.fromString("11111111-1111-1111-1111-111111111111"));

        List<Reservation> reservations = reservationRepository.findByBatchIdAndIsActiveTrue(batch.getId());

        reservations.forEach(reservation -> reservation.setIsActive(false));
        reservationRepository.saveAll(reservations);

        int total = batch.getTotal();
        int sold = reservationRepository
                .findByBatchIdAndIsActiveTrue(batch.getId())
                .size();
        int available = total - sold;

        return BatchResponse.builder()
                .total(total)
                .sold(sold)
                .available(available)
                .build();
    }
}
