package com.wmm.api.tags.infrastructure.adapter.input.rest;

import com.wmm.api.tags.application.usecases.CreateTagUseCase;
import com.wmm.api.tags.application.usecases.DeleteTagUseCase;
import com.wmm.api.tags.domain.entities.Tag;
import com.wmm.api.tags.infrastructure.adapter.input.rest.model.TagMapper;
import com.wmm.api.tags.infrastructure.adapter.input.rest.model.request.NewTagRequest;
import com.wmm.api.tags.infrastructure.adapter.input.rest.model.response.TagResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("tags")
public class TagInputAdapter {

    private final CreateTagUseCase createTagUseCase;

    private final DeleteTagUseCase deleteTagUseCase;

    @Autowired
    private final TagMapper tagMapper;


    @PostMapping
    public TagResponse saveNewTag(@RequestBody NewTagRequest tagRequest) {
        Tag createdTag = createTagUseCase
                .execute(tagMapper.newRequestToModel(tagRequest));
        return tagMapper.modelToResponse(createdTag);
    }

    @DeleteMapping
    public void deleteTag(@RequestParam String tagId) {
        deleteTagUseCase.execute(tagId);
    }
}