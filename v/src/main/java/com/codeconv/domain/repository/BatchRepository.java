package com.codeconv.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

import com.codeconv.domain.entity.Batch;

public interface BatchRepository extends JpaRepository<Batch, UUID> {}
