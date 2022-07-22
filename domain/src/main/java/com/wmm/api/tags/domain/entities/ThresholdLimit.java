package com.wmm.api.tags.domain.entities;

import com.wmm.api.tags.domain.vo.ThresholdPeriod;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class ThresholdLimit {

    private final double maxExpense;
    private final ThresholdPeriod thresholdPeriod;

    public String getThresholdPeriodName() {
        return this.thresholdPeriod.name();
    }

    public static ThresholdLimit buildMonthlyThreshold(double amount) {
        return new ThresholdLimit(amount, ThresholdPeriod.MONTHLY);
    }

    public static ThresholdLimit buildDailyThreshold(double amount) {
        return new ThresholdLimit(amount, ThresholdPeriod.DAILY);
    }

    public static ThresholdLimit buildWeeklyThreshold(double amount) {
        return new ThresholdLimit(amount, ThresholdPeriod.WEEKLY);
    }

    public static ThresholdLimit buildNoLimitThreshold() {
        return new ThresholdLimit(0, ThresholdPeriod.NO_LIMIT);
    }

    public static ThresholdLimit byPeriodName(double amount, String periodName) {
        return new ThresholdLimit(amount, ThresholdPeriod.valueOf(periodName));
    }
}
