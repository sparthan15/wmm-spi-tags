package com.wmm.api.tags.infrastructure.adapters;

import com.wmm.api.tags.application.ports.output.TagOutputPort;
import com.wmm.api.tags.domain.entities.Tag;
import com.wmm.api.tags.domain.exception.TagNotFoundException;
import com.wmm.api.tags.infrastructure.adapters.input.rest.model.TagMapper;
import com.wmm.api.tags.infrastructure.adapters.output.mongodb.entity.TagEntity;
import com.wmm.api.tags.infrastructure.adapters.output.mongodb.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TagOutputAdapter implements TagOutputPort {

    private final TagRepository tagRepository;

    @Autowired
    private final TagMapper tagMapper;

    @Override
    public Tag create(Tag tag) {

        return tagRepository.save(tagMapper.modelToEntity(tag)).toModel();
    }

    @Override
    public void delete(String tagId) {
        TagEntity tagToDelete = tagRepository.findById(tagId)
                .orElseThrow(() -> new TagNotFoundException());
        tagRepository.delete(tagToDelete);
    }
}