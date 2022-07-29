package com.wmm.api.tags.infrastructure.adapter.input.rest;

import com.wmm.api.tags.application.usecases.GetTagsUseCase;
import com.wmm.api.tags.domain.entities.Tag;
import com.wmm.api.tags.infrastructure.adapter.output.mongodb.entity.TagEntity;
import com.wmm.api.tags.infrastructure.adapter.output.mongodb.repository.TagRepository;
import com.wmm.api.tags.infrastructure.adapters.model.response.TagResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    private final TagRepository repository;

    @GetMapping
    public Page<TagEntity> getTagsByUser(@RequestParam String userId, Pageable pageable){
        return repository.findByUserId(userId, pageable);
    }
}
