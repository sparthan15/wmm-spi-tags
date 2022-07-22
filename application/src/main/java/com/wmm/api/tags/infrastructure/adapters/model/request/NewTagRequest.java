package com.wmm.api.tags.infrastructure.adapters.model.request;

import com.wmm.api.tags.domain.entities.Tag;
import com.wmm.api.tags.domain.entities.ThresholdLimit;
import lombok.*;

@RequiredArgsConstructor
@Getter
@ToString
@Builder
public class NewTagRequest {
    private final String name;
    private final String description;
    private final Double amount;
    private final String period;
    private final String userId;


    public Tag toModel() {
        return Tag.builder()
                .name(name)
                .description(description)
                .thresholdLimit(ThresholdLimit.byPeriodName(amount,
                        period))
                .userId(userId)
                .build();
    }

}
