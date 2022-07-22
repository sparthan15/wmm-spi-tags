package com.wmm.api.tags.infrastructure.adapter.config;

import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class ErrorResponse {
    private final String message;
    private LocalDateTime date = LocalDateTime.now();
}
