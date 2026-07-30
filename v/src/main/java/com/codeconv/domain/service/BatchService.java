package com.codeconv.domain.service;

import com.codeconv.common.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

    public BatchResponse viewBatch() {
        Batch batch = batchRepository.findById(UUID.fromString("11111111-1111-1111-1111-111111111111"))
                .orElseThrow(() -> new ResourceNotFoundException("Wedding not found"));
        List<Reservation> reservations = reservationRepository.findByBatchId(batch.getId());

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
        return BatchResponse.builder().total(100).sold(0).available(100).build();
    }
}
