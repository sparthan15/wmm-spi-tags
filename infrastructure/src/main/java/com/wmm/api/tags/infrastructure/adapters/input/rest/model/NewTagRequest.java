package com.wmm.api.tags.infrastructure.adapters.input.rest.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Builder
public class NewTagRequest {
    private String name;
    private String description;
    private Double amount;
    private String period;
    private String userId;
}