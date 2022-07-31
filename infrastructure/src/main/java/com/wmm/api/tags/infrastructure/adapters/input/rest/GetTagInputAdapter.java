package com.wmm.api.tags.infrastructure.adapters.input.rest;

import com.wmm.api.tags.infrastructure.adapters.input.rest.model.TagMapper;
import com.wmm.api.tags.infrastructure.adapters.input.rest.model.response.TagResponse;
import com.wmm.api.tags.infrastructure.adapters.output.mongodb.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("tags")
public class GetTagInputAdapter {

    private final TagRepository repository;

    @Autowired
    private final TagMapper tagMapper;

    @GetMapping
    public Page<TagResponse> getTagsByUser(@RequestParam String userId, Pageable pageable) {
        return new PageImpl<>(repository.findByUserId(userId, pageable)
                .stream()
                .map(tagMapper::entityToResponse)
                .collect(Collectors.toList()));
    }
}