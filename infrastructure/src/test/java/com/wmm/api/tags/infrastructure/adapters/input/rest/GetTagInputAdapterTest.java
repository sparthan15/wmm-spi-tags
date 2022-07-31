package com.wmm.api.tags.infrastructure.adapters.input.rest;

import com.wmm.api.tags.infrastructure.adapters.input.rest.model.TagMapper;
import com.wmm.api.tags.infrastructure.adapters.input.rest.model.response.TagResponse;
import com.wmm.api.tags.infrastructure.adapters.output.mongodb.entity.TagEntity;
import com.wmm.api.tags.infrastructure.adapters.output.mongodb.repository.TagRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.*;
import util.TestUtil;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GetTagInputAdapterTest {

    @Mock
    private TagRepository repository;

    @Mock
    private TagMapper tagMapper;

    @InjectMocks
    private GetTagInputAdapter tagInputAdapter;

    private String USER_ID = "1ASDD";

    @Test
    public void getPaginatedTagsByUserId() {
        Pageable pageable = PageRequest.of(0, 1,
                Sort.by(new String[]{"name"}));

        TagEntity tagEntity = TestUtil.createNewMonthlyTagEntity();
        PageImpl page = new PageImpl(List.of(tagEntity));

        when(tagMapper.entityToResponse(tagEntity)).thenReturn(TestUtil.createdMonthlyTagResponse());

        when(repository.findByUserId(USER_ID, pageable)).thenReturn(page);
        Page<TagResponse> response = tagInputAdapter.getTagsByUser(USER_ID, pageable);
        Assertions.assertThat(response).isNotNull();
    }
}