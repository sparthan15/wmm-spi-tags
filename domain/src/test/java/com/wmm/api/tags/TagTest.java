package com.wmm.api.tags;


import com.wmm.api.tags.domain.entities.Tag;
import com.wmm.api.tags.domain.entities.ThresholdLimit;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TagTest {

    Tag monthlyLimitedTag = Tag.builder()
            .name("coffee")
            .description("this is a tag to group coffee expenses ")
            .thresholdLimit(ThresholdLimit.buildMonthlyThreshold(100.00))
            .build();

    Tag dailyLimitedTag = Tag.builder()
            .name("Candies")
            .description("this is a tag to group coffee expenses ")
            .thresholdLimit(ThresholdLimit.buildDailyThreshold(100.00))
            .build();

    @Test
    public void aTagHaveAAmountLimitDefinitionsByMonth(){
        assertThat(monthlyLimitedTag).isNotNull();
        assertThat(monthlyLimitedTag.getDescription()).isNotNull();
        assertThat(monthlyLimitedTag.getName()).isNotNull();
        assertThat(monthlyLimitedTag.getThresholdLimit().getThresholdPeriod());

    }

    @Test
    public void validatePredicateIsMonthlyTag(){
        assertThat(monthlyLimitedTag.isMonthly()).isNotNull();
        assertThat(monthlyLimitedTag.isMonthly().test(monthlyLimitedTag)).isTrue();
    }

    @Test
    public void aTagMustBeOwnedByAUser(){
        assertThat(monthlyLimitedTag.getUserId()).isNotNull();
    }

    @Test
    public void aTagNeedAnIdToThatIdentifyIt(){
        assertThat(monthlyLimitedTag.getId()).isNull();
    }

    @Test
    public void isPosibleCreateATagObjectWithOutId(){
        Tag tagToBeCreated = new Tag("tag 1", "Desc 1", ThresholdLimit.buildMonthlyThreshold(100),
                "123");
        assertThat(tagToBeCreated.getId()).isNull();

    }
}
