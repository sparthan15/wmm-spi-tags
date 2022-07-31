package com.wmm.api.tags.infrastructure;

import com.wmm.api.tags.infrastructure.adapters.output.mongodb.entity.TagEntity;
import com.wmm.api.tags.infrastructure.adapters.output.mongodb.repository.TagRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import util.TestUtil;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = TagsApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TagsApplicationTests {

    @Autowired
    private TagRepository tagRepository;

    @Test
    public void testSave() {
        TagEntity tagEntity = new TagEntity(TestUtil.createNewMonthlyTagRequest());
        TagEntity savedTag = tagRepository.save(tagEntity);
        assertThat(savedTag.getId()).isNotNull();
    }

}