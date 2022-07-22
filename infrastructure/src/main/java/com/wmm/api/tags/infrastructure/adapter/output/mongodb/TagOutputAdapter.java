package com.wmm.api.tags.infrastructure.adapter.output.mongodb;

import com.wmm.api.tags.application.ports.output.TagOutputPort;
import com.wmm.api.tags.domain.entities.Tag;
import com.wmm.api.tags.infrastructure.adapter.output.mongodb.entity.TagEntity;
import com.wmm.api.tags.infrastructure.adapter.output.mongodb.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TagOutputAdapter implements TagOutputPort {

    private final TagRepository tagRepository;

    @Override
    public Tag create(Tag tag) {

        return tagRepository.save(TagEntity.builder()
                .name(tag.getName())
                .description(tag.getDescription())
                .thresholdLimit(tag.getThresholdLimit())
                .userId(tag.getUserId())
                .build()).toModel();
    }
}
