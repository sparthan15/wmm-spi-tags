package com.wmm.api.tags;

import com.wmm.api.tags.domain.entities.ThresholdLimit;
import com.wmm.api.tags.domain.vo.ThresholdPeriod;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ThresholdLimitTest {
    ThresholdLimit thresholdMonthlyLimited = ThresholdLimit.buildMonthlyThreshold(100_00);
    ThresholdLimit thresholdDailyLimited = ThresholdLimit.buildDailyThreshold(100_00);
    ThresholdLimit thresholdWeeklyLimited = ThresholdLimit.buildWeeklyThreshold(100_00);
    ThresholdLimit thresholdNoLimited = ThresholdLimit.buildNoLimitThreshold();

    @Test
    public void aThresholdCanBeMonthly() {
        assertThat(thresholdMonthlyLimited.getMaxExpense()).isEqualTo(100_00);
        assertThat(thresholdMonthlyLimited.getThresholdPeriod()).isEqualTo(ThresholdPeriod.MONTHLY);
    }

    @Test
    public void aThresholdCanBeWeekly() {
        assertThat(thresholdWeeklyLimited.getMaxExpense()).isEqualTo(100_00);
        assertThat(thresholdWeeklyLimited.getThresholdPeriod()).isEqualTo(ThresholdPeriod.WEEKLY);
    }

    @Test
    public void aThresholdCanBeDaily() {
        assertThat(thresholdDailyLimited.getMaxExpense()).isEqualTo(100_00);
        assertThat(thresholdDailyLimited.getThresholdPeriod()).isEqualTo(ThresholdPeriod.DAILY);
    }

    @Test
    public void aThresholdCanNoHaveLimitAndItAmountHaveToBeZero() {
        assertThat(thresholdNoLimited.getMaxExpense()).isEqualTo(0);
        assertThat(thresholdNoLimited.getThresholdPeriod()).isEqualTo(ThresholdPeriod.NO_LIMIT);
    }

    @Test
    public void aThresholdCanBeBuildThroughAString() {
        assertThat(ThresholdLimit.byPeriodName(100_00, "WEEKLY").getThresholdPeriod())
                .isEqualTo(ThresholdPeriod.WEEKLY);
        assertThat(ThresholdLimit.byPeriodName(100_00, "DAILY").getThresholdPeriod())
                .isEqualTo(ThresholdPeriod.DAILY);
        assertThat(ThresholdLimit.byPeriodName(100_00, "NO_LIMIT").getThresholdPeriod())
                .isEqualTo(ThresholdPeriod.NO_LIMIT);
    }


}
