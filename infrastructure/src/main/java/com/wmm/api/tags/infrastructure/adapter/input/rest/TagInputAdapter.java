package com.wmm.api.tags.infrastructure.adapter.input.rest;

import com.wmm.api.tags.application.usecases.CreateTagUseCase;
import com.wmm.api.tags.domain.entities.Tag;
import com.wmm.api.tags.domain.entities.ThresholdLimit;
import com.wmm.api.tags.infrastructure.adapters.model.request.NewTagRequest;
import com.wmm.api.tags.infrastructure.adapters.model.response.TagResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("tags")
public class TagInputAdapter {

    private final CreateTagUseCase createTagUseCase;
    private TagResponse tagResponse = new TagResponse();

    @PostMapping
    public TagResponse saveNewTag(@RequestBody NewTagRequest tagRequest) {
        System.out.println(tagRequest);
        Tag createdTag = createTagUseCase.execute(tagRequest.toModel());
        tagResponse.mapFromModel(createdTag);
        return tagResponse;
    }
}
