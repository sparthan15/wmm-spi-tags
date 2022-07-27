package com.wmm.api.tags.infrastructure.adapters.model.request;

import com.wmm.api.tags.domain.entities.Tag;
import com.wmm.api.tags.domain.entities.ThresholdLimit;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Builder
public class NewTagRequest {
    private  String name;
    private  String description;
    private  Double amount;
    private  String period;
    private  String userId;


    public Tag toModel() {
        System.out.println( ThresholdLimit.byPeriodName(amount,
                period));
        return Tag.builder()
                .name(name)
                .description(description)
                .thresholdLimit(
                        ThresholdLimit.byPeriodName(amount,
                        period))
                .userId(userId)
                .build();
    }

}
