package com.wmm.api.tags.infrastructure.adapter.output.mongodb.entity;

import com.wmm.api.tags.domain.entities.Tag;
import com.wmm.api.tags.domain.entities.ThresholdLimit;
import com.wmm.api.tags.infrastructure.adapters.model.request.NewTagRequest;
import com.wmm.api.tags.infrastructure.adapters.model.response.TagResponse;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Setter
@Builder
@Getter
@ToString
@Document("tags")
public class TagEntity {
    @Id
    private  String id;
    @Version
    private  Long version;
    private  String name;
    private  String description;
    private  ThresholdLimit thresholdLimit;
    private  String userId;


    public TagResponse toResponse() {
        return TagResponse.builder()
                .id(id)
                .name(name)
                .description(description)
                .period(thresholdLimit.getThresholdPeriod().name())
                .maxExpense(thresholdLimit.getMaxExpense())
                .build();
    }

    public Tag toModel() {
        return Tag.builder()
                .id(id)
                .name(name)
                .description(description)
                .thresholdLimit(thresholdLimit)
                .userId(userId)
                .build();
    }

    public TagEntity(Tag tag) {
        this.id = tag.getId();
        this.name = tag.getName();
        this.description = tag.getDescription();
        this.thresholdLimit = this.getThresholdLimit();
        this.userId = this.getUserId();
        this.version = this.getVersion();
    }

    public TagEntity(NewTagRequest newTagRequest) {
        this.id = null;
        this.version = null;
        this.name = newTagRequest.getName();
        this.description = newTagRequest.getDescription();
        this.thresholdLimit = ThresholdLimit.byPeriodName(newTagRequest.getAmount(),
                newTagRequest.getPeriod());
        this.userId = newTagRequest.getUserId();
    }

}

