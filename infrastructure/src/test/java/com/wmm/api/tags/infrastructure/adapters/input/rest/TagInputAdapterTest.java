package com.wmm.api.tags.infrastructure.adapters.input.rest;

import com.wmm.api.tags.application.usecases.CreateTagUseCase;
import com.wmm.api.tags.application.usecases.DeleteTagUseCase;
import com.wmm.api.tags.domain.entities.Tag;
import com.wmm.api.tags.infrastructure.adapters.input.rest.model.NewTagRequest;
import com.wmm.api.tags.infrastructure.adapters.input.rest.model.TagMapper;
import com.wmm.api.tags.infrastructure.adapters.input.rest.model.response.TagResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import util.TestUtil;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TagInputAdapterTest {

    @Mock
    private CreateTagUseCase createTagUseCase;

    @Mock
    private DeleteTagUseCase deleteTagUseCase;

    @Mock
    private TagMapper tagMapper;

    @InjectMocks
    private TagInputAdapter tagInputAdapter;

    private NewTagRequest tagRequest = TestUtil.createNewMonthlyTagRequest();

    @Test
    public void saveNewTagTest() {
        Assertions.assertThat(tagMapper).isNotNull();
        Tag tag = Tag.builder().build();
        when(tagMapper.newRequestToModel(tagRequest)).thenReturn(tag);
        when(tagMapper.modelToResponse(tag)).thenReturn(TagResponse.builder().build());
        when(createTagUseCase.execute(tag)).thenReturn(tag);
        Assertions.assertThat(tagInputAdapter.saveNewTag(tagRequest)).isNotNull();
    }

    @Test
    public void deleteTagTest() {
        String tagId = "12312312";
        doNothing().when(deleteTagUseCase).execute(tagId);
        tagInputAdapter.deleteTag(tagId);
        Mockito.verify(deleteTagUseCase, Mockito.times(1)).execute(tagId);
    }
}