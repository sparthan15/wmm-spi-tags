package com.wmm.api.tags.infrastructure.adapters.input.rest;

import com.wmm.api.tags.application.usecases.CreateTagUseCase;
import com.wmm.api.tags.domain.entities.Tag;
import com.wmm.api.tags.infrastructure.adapter.input.rest.TagInputAdapter;
import com.wmm.api.tags.infrastructure.adapters.model.request.NewTagRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import util.TestUtil;

@ExtendWith(MockitoExtension.class)
public class TagInputAdapterTest {


    private NewTagRequest tagRequest = TestUtil.createNewMonthlyTagRequest();

    @Mock
    private CreateTagUseCase createTagUseCase;

    @InjectMocks
    private TagInputAdapter tagInputAdapter;

    @Test
    public void saveNewTagTest(){
        Mockito.when(createTagUseCase.execute(tagRequest.toModel())).thenReturn(tagRequest.toModel());
        Assertions.assertThat(tagInputAdapter.saveNewTag(tagRequest)).isNotNull();
    }

    private void setup(){
        tagInputAdapter = new TagInputAdapter(createTagUseCase);
    }
}
