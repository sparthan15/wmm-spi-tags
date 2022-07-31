package com.wmm.api.tags.infrastructure.adapters.input.rest.model.response;

import com.wmm.api.tags.domain.entities.Tag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TagResponse {
    private String id;
    private String name;
    private String description;
    private Double amount;
    private String period;
    private String userId;

    public TagResponse(Tag tag) {
        this.id = tag.getId();
        this.amount = tag.getThresholdLimit().getMaxExpense();
        this.userId = tag.getUserId();
        this.name = tag.getName();
        this.description = tag.getDescription();
        this.period = tag.getThresholdLimit().getThresholdPeriodName();
        this.amount = tag.getThresholdLimit().getMaxExpense();
    }
}