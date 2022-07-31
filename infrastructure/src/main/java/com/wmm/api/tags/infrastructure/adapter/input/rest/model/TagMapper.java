package com.wmm.api.tags.infrastructure.adapter.input.rest.model;

import com.wmm.api.tags.domain.entities.Tag;
import com.wmm.api.tags.domain.entities.ThresholdLimit;
import com.wmm.api.tags.infrastructure.adapter.input.rest.model.request.NewTagRequest;
import com.wmm.api.tags.infrastructure.adapter.input.rest.model.response.TagResponse;
import com.wmm.api.tags.infrastructure.adapter.output.mongodb.entity.TagEntity;
import org.springframework.stereotype.Component;

@Component
public class TagMapper {

    public TagEntity modelToEntity(Tag tag) {
        return TagEntity.builder()
                .id(tag.getId())
                .name(tag.getName())
                .description(tag.getDescription())
                .thresholdLimit(tag.getThresholdLimit())
                .userId(tag.getUserId())
                .build();
    }

    public Tag newRequestToModel(NewTagRequest tagRequest) {
        return Tag.builder()
                .name(tagRequest.getName())
                .description(tagRequest.getDescription())
                .thresholdLimit(
                        ThresholdLimit.byPeriodName(tagRequest.getAmount(),
                                tagRequest.getPeriod()))
                .userId(tagRequest.getUserId())
                .build();
    }

    public TagResponse modelToResponse(Tag tag) {
        return TagResponse.builder()
                .id(tag.getId())
                .name(tag.getName())
                .description(tag.getDescription())
                .amount(tag.getThresholdLimit().getMaxExpense())
                .period(tag.getThresholdLimit().getThresholdPeriod().name())
                .userId(tag.getUserId())
                .build();
    }
}