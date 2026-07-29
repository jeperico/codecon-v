package com.codeconv.domain.repository;

import com.codeconv.domain.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReservationRepository extends JpaRepository<UUID, Reservation> {
}
