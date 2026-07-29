package com.codeconv.domain.repository;

import com.codeconv.domain.entity.Batch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BatchRepository extends JpaRepository<UUID, Batch> {
}
