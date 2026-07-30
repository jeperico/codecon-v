package com.codeconv.domain.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.codeconv.domain.dto.BatchResponse;
import com.codeconv.domain.service.BatchService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/batch")
@RequiredArgsConstructor
public class BatchController {

    private final BatchService batchService;

    @GetMapping
    public ResponseEntity<BatchResponse> getBatch() {
        return ResponseEntity.ok(batchService.viewBatch());
    }

    @PostMapping("/reset")
    public ResponseEntity<BatchResponse> postBatch() {
        return ResponseEntity.ok(batchService.resetBatch());
    }
}
