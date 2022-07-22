package com.wmm.api.tags.infrastructure.adapters.ouput.mongodb;

import com.wmm.api.tags.domain.entities.Tag;
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

@ExtendWith(MockitoExtension.class)

public class TagOutputAdapterTest {

    @Mock
    private TagRepository tagRepository;

    @InjectMocks
    private TagOutputAdapter tagOutputAdapter;

    @Test
    public void testSaveTagReturnNoNull() {
        Tag newTag = TestUtil.createNewMonthlyTag();
        TagEntity tagEntity = new TagEntity(newTag);

        Mockito.when(tagRepository.save(tagEntity)).thenReturn(tagEntity);
        Tag savedTag = tagOutputAdapter.create(newTag);
        Assertions.assertThat(savedTag).isNotNull();
    }


}
