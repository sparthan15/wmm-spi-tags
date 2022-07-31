package com.wmm.api.tags.infrastructure.adapters.ouput.mongodb;

import com.wmm.api.tags.domain.entities.Tag;
import com.wmm.api.tags.domain.exception.TagNotFoundException;
import com.wmm.api.tags.infrastructure.adapter.input.rest.model.TagMapper;
import com.wmm.api.tags.infrastructure.adapter.output.mongodb.TagOutputAdapter;
import com.wmm.api.tags.infrastructure.adapter.output.mongodb.entity.TagEntity;
import com.wmm.api.tags.infrastructure.adapter.output.mongodb.repository.TagRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import util.TestUtil;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class TagOutputAdapterTest {

    @Mock
    private TagRepository tagRepository;

    @Mock
    private TagMapper tagMapper;

    @InjectMocks
    private TagOutputAdapter tagOutputAdapter;

    @Test
    public void testSaveTagReturnNoNull() {
        Tag newTag = TestUtil.createNewMonthlyTag();
        TagEntity tagEntity = new TagEntity(newTag);
        when(tagMapper.modelToEntity(newTag)).thenReturn(tagEntity);
        when(tagRepository.save(tagEntity)).thenReturn(tagEntity);
        Tag savedTag = tagOutputAdapter.create(newTag);
        Assertions.assertThat(savedTag).isNotNull();
    }

    @Test
    public void deleteTagTest() {
        String tagId = "1231GGD";
        TagEntity tagToDelete = new TagEntity();

        when(tagRepository.findById(tagId)).thenReturn(java.util.Optional.of(tagToDelete));
        Mockito.doNothing().when(tagRepository).delete(tagToDelete);
        tagOutputAdapter.delete(tagId);
        Mockito.verify(tagRepository, Mockito.times(1)).delete(tagToDelete);
    }


    @Test
    public void givenTagWithIdDoesNotExistThenThrowAnException() {
        Assertions.assertThatThrownBy(() -> {
            String tagId = "1231GGD";
            tagOutputAdapter.delete(tagId);
        }).isInstanceOf(TagNotFoundException.class);


    }
}