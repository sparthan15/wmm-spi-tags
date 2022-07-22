package com.wmm.api.tags.domain.entities;

import com.wmm.api.tags.domain.vo.ThresholdPeriod;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.function.Predicate;

@Builder
@RequiredArgsConstructor
@Getter
@ToString
public class Tag {

    private final String id;
    private final String name;
    private final String description;
    private final ThresholdLimit thresholdLimit;
    private final String userId;

    public Tag(String name, String description, ThresholdLimit thresholdLimit, String userId) {
        this.name = name;
        this.description = description;
        this.thresholdLimit = thresholdLimit;
        this.userId = userId;
        this.id = null;
    }

    public Predicate<Tag> isMonthly() {
        return tag -> this.getThresholdLimit().getThresholdPeriod().equals(ThresholdPeriod.MONTHLY);
    }


}
