package com.wmm.api.tags.infrastructure.adapters.ouput.mongodb;

import com.wmm.api.tags.domain.entities.ThresholdLimit;
import com.wmm.api.tags.infrastructure.adapter.output.mongodb.entity.TagEntity;
import org.junit.jupiter.api.Test;
import util.TestUtil;

import static org.assertj.core.api.Assertions.assertThat;

public class TagEntityTest {

    @Test
    public void insertATagWithNoThresholdLimit() {
        TagEntity newTagEntity = new TagEntity(null, 123L, "RAPPI", "Shopping at home",
                ThresholdLimit.buildNoLimitThreshold(), TestUtil.USER_ID_TEST);
        assertThat(newTagEntity.getId()).isNull();
        assertThat(newTagEntity.getName()).isNotNull();
        assertThat(newTagEntity.getDescription()).isNotNull();
        assertThat(newTagEntity.getThresholdLimit()).isNotNull();
        assertThat(newTagEntity.getUserId()).isNotNull();
    }

    @Test
    public void tagEntityCanBeBuildFromATagRequest(){
        TagEntity newTagEntity = new TagEntity(TestUtil.createNewMonthlyTagRequest());
        System.out.println(newTagEntity);
        assertThat(newTagEntity.getId()).isNull();
        assertThat(newTagEntity.getName()).isNotNull();
        assertThat(newTagEntity.getDescription()).isNotNull();
        assertThat(newTagEntity.getThresholdLimit()).isNotNull();
        assertThat(newTagEntity.getUserId()).isNotNull();
    }
}
