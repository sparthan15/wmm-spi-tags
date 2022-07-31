package com.wmm.api.tags.infrastructure.adapters.input.rest;

import com.wmm.api.tags.application.usecases.GetTagsUseCase;
import com.wmm.api.tags.domain.entities.Tag;
import com.wmm.api.tags.domain.entities.ThresholdLimit;
import com.wmm.api.tags.infrastructure.adapter.input.rest.GetTagInputAdapter;
import com.wmm.api.tags.infrastructure.adapter.output.mongodb.entity.TagEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class GetTagInputAdapterTest {

    @InjectMocks
    private GetTagInputAdapter tagInputAdapter;

    @Mock
    private GetTagsUseCase getTagsUseCase;

    private String USER_ID = "1ASDD";

    @Test
    public void test() {
        Mockito.when(getTagsUseCase.getTagsByUserId(USER_ID)).thenReturn(List.of(Tag.builder()
                .thresholdLimit(ThresholdLimit.buildNoLimitThreshold()).build()));
        Page<TagEntity> response = tagInputAdapter.getTagsByUser(USER_ID, PageRequest.of(0, 1,
                Sort.by(new String[]{"detail"})));
        Assertions.assertThat(response).isNotNull();
    }
}