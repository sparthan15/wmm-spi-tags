package util;

import com.wmm.api.tags.domain.entities.Tag;
import com.wmm.api.tags.domain.entities.ThresholdLimit;
import com.wmm.api.tags.domain.vo.ThresholdPeriod;
import com.wmm.api.tags.infrastructure.adapter.input.rest.model.request.NewTagRequest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;

public class TestUtil {

    public static final String USER_ID_TEST = "123KSJ";
    public static final BigDecimal CREDIT_AMOUNT = BigDecimal.valueOf(12033.2);
    public static LocalDateTime START_DATE = LocalDateTime.of(2022, Month.JULY, 1, 0, 0, 0);
    public static LocalDateTime END_DATE = LocalDateTime.of(2022, Month.JULY, 31, 0, 0, 0);

    public static NewTagRequest createNewMonthlyTagRequest() {
        return NewTagRequest.builder()
                .userId(USER_ID_TEST)
                .amount(0.0)
                .name("RAPPI")
                .description("Home shopping")
                .period(ThresholdPeriod.MONTHLY.name())
                .build();

    }

    public static Tag createNewMonthlyTag() {
        return Tag.builder()
                .userId(USER_ID_TEST)
                .name("RAPPI")
                .description("Home shopping")
                .thresholdLimit(ThresholdLimit.byPeriodName(10.0, ThresholdPeriod.MONTHLY.name()))
                .build();

    }

    public static NewTagRequest createdMonthlyTagRequest() {
        return NewTagRequest.builder()
                .userId(USER_ID_TEST)
                .amount(0.0)
                .name("RAPPI")
                .description("Home shopping")
                .period(ThresholdPeriod.MONTHLY.name())
                .build();

    }


}