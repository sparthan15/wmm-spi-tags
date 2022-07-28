package com.wmm.api.tags.infrastructure.adapters.model.response;

import com.wmm.api.tags.domain.entities.Tag;
import org.junit.jupiter.api.Test;
import util.TestUtil;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TagResponseTest {

    @Test
    public void test() {
        Tag tag = TestUtil.createNewMonthlyTag();
        TagResponse tagResponse = new TagResponse(tag);
        assertThat(tagResponse).isNotNull();
        assertThat(tagResponse.getId()).isEqualTo(tag.getId());
        assertThat(tagResponse.getUserId()).isEqualTo(tag.getUserId());
        assertThat(tagResponse.getAmounnt()).isEqualTo(tag.getThresholdLimit().getMaxExpense());
        assertThat(tagResponse.getPeriod()).isEqualTo(tag.getThresholdLimit().getThresholdPeriod().name());
        assertThat(tagResponse.getUserId()).isEqualTo(tag.getUserId());
    }
}
