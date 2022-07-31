package com.wmm.api.tags.infrastructure.adapter.input.rest.model.request;

import com.wmm.api.tags.domain.vo.ThresholdPeriod;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class tagRequestTest {

    @Test
    public void testToModelNewTag() {
        NewTagRequest tagRequest = new NewTagRequest("RAPPI", "Home shopping", 10.0, "MONTHLY",
                "123KK");
        assertThat(tagRequest).isNotNull();
        assertThat(tagRequest.getName()).isEqualTo("RAPPI");
        assertThat(tagRequest.getDescription()).isEqualTo("Home shopping");
        assertThat(tagRequest.getAmount()).isEqualTo(10.0);
        assertThat(tagRequest.getPeriod()).isEqualTo(ThresholdPeriod.MONTHLY.name());
    }

}