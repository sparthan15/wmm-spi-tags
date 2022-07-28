package com.wmm.api.tags.infrastructure.adapter.input.rest;

import com.wmm.api.tags.application.usecases.GetTagsUseCase;
import com.wmm.api.tags.infrastructure.adapters.model.response.TagResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
@RestController
@RequestMapping("tags")
public class GetTagInputAdapter {

    private final GetTagsUseCase getTagsUseCase;

    @GetMapping
    public List<TagResponse> getTagsByUser(@RequestParam String userId){
        return getTagsUseCase.getTagsByUserId(userId)
                .stream()
                .map(t->new TagResponse(t))
                .collect(toList());
    }
}
