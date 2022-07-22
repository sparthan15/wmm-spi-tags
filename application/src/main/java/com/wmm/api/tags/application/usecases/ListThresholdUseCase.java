package com.wmm.api.tags.application.usecases;

import com.wmm.api.tags.domain.vo.ThresholdPeriod;

import java.util.List;

public interface ListThresholdUseCase {

    List<ThresholdPeriod> execute();
}
