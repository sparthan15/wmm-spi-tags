package com.wmm.api.tags.infrastructure.adapters.input.rest.model;

import com.wmm.api.tags.domain.entities.Tag;
import com.wmm.api.tags.domain.entities.ThresholdLimit;
import com.wmm.api.tags.infrastructure.adapters.input.rest.model.response.TagResponse;
import com.wmm.api.tags.infrastructure.adapters.output.mongodb.entity.TagEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TagMapperTest {

    private TagMapper tagMapper = new TagMapper();


    @Test
    public void modelToEntityTest() {
        TagResponse tagResponse = tagMapper.modelToResponse(Tag.builder()
                .name("what a name")
                .description("what a description")
                .userId("123123as")
                .thresholdLimit(ThresholdLimit.buildNoLimitThreshold())
                .id("111")
                .build());
        assertEquals(tagResponse.getUserId(), "123123as");
        assertEquals(tagResponse.getName(), "what a name");
        assertEquals(tagResponse.getDescription(), "what a description");
        assertEquals(tagResponse.getId(), "111");
        assertEquals(tagResponse.getAmount(), 0);
    }

    @Test
    public void modelToEntity() {
        TagEntity tagEntity = tagMapper.modelToEntity(Tag.builder()
                .name("what a name")
                .description("what a description")
                .userId("123123as")
                .thresholdLimit(ThresholdLimit.buildNoLimitThreshold())
                .id("111")
                .build());
        assertEquals(tagEntity.getUserId(), "123123as");
        assertEquals(tagEntity.getName(), "what a name");
        assertEquals(tagEntity.getDescription(), "what a description");
        assertEquals(tagEntity.getId(), "111");
        assertEquals(tagEntity.getThresholdLimit().getMaxExpense(), 0);
        assertEquals(tagEntity.getThresholdLimit().getThresholdPeriod().name(), "NO_LIMIT");
    }

    @Test
    public void newRequestToModel() {

        Tag tag = tagMapper.newRequestToModel(NewTagRequest.builder()
                .name("what a name")
                .description("what a description")
                .userId("123123as")
                .amount(0.0)
                .period("NO_LIMIT")
                .build());
        assertEquals(tag.getUserId(), "123123as");
        assertEquals(tag.getName(), "what a name");
        assertEquals(tag.getDescription(), "what a description");
        assertNull(tag.getId());
        assertEquals(tag.getThresholdLimit().getMaxExpense(), 0);
        assertEquals(tag.getThresholdLimit().getThresholdPeriod().name(), "NO_LIMIT");
    }

    @Test
    public void entityToResponseTest() {

        TagResponse tagResponse = tagMapper.entityToResponse(TagEntity.builder()
                .id("1231312")
                .name("what a name")
                .description("what a description")
                .userId("123123as")
                .thresholdLimit(ThresholdLimit.buildNoLimitThreshold())
                .build());
        assertEquals(tagResponse.getUserId(), "123123as");
        assertEquals(tagResponse.getName(), "what a name");
        assertEquals(tagResponse.getDescription(), "what a description");
        assertEquals(tagResponse.getAmount(), 0);
        assertEquals(tagResponse.getPeriod(), "NO_LIMIT");
        assertEquals(tagResponse.getId(), "1231312");
    }
}