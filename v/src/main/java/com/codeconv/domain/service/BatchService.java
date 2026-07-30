package com.codeconv.domain.service;

import org.springframework.stereotype.Service;

import com.codeconv.domain.dto.BatchResponse;
import com.codeconv.domain.repository.BatchRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BatchService {

    private final BatchRepository batchRepository;

    public BatchResponse viewBatch() {
        return BatchResponse.builder().total(100).sold(0).available(100).build();
    }

    public BatchResponse resetBatch() {
        return BatchResponse.builder().total(100).sold(0).available(100).build();
    }
}
