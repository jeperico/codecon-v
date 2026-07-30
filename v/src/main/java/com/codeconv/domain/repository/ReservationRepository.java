package com.codeconv.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

import com.codeconv.domain.entity.Reservation;

public interface ReservationRepository extends JpaRepository<UUID, Reservation> {}
