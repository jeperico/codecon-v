package com.codeconv.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

import com.codeconv.domain.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, UUID> {
    List<Reservation> findByBatchId(UUID id);
}
