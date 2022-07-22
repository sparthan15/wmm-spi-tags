package com.wmm.api.tags.application.usecases;

import com.wmm.api.tags.application.ports.output.TagOutputPort;
import com.wmm.api.tags.application.ports.input.CreateTagInputPort;
import com.wmm.api.tags.domain.entities.Tag;
import com.wmm.api.tags.domain.entities.ThresholdLimit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.TestObjectCreator.insertedTag;

@ExtendWith(MockitoExtension.class)
public class CreateTagUseCaseTest {

    @Mock
    private TagOutputPort tagOutputPort;

    @InjectMocks
    private CreateTagInputPort createTagInputPort;

    private Tag tag;

    @BeforeEach
    public void init() {
        tag = Tag.builder()
                .name("RAPPI")
                .description("xxx")
                .thresholdLimit(ThresholdLimit.buildNoLimitThreshold())
                .userId("123LK")
                .build();
        Mockito.when(tagOutputPort.create(tag)).thenReturn(insertedTag(getBuildNoLimitThreshold()));

    }

    @Test
    public void noLimitThresholdHaveAZeroAmount() {
        Tag createdTag =
                createTagInputPort.execute(tag);
        assertThat(createdTag).isNotNull();
        assertThat(tag.getThresholdLimit().getMaxExpense()).isEqualTo(0.0);
    }

    private ThresholdLimit getBuildNoLimitThreshold() {
        return ThresholdLimit.buildNoLimitThreshold();
    }

    @Test
    public void givenIWantToCreateATagWithNoLimitThresholdThenAnNewIdIsGenerated() {

        Tag createdTag =
                createTagInputPort.execute(tag);
        assertThat(createdTag.getId()).isNotNull();
    }


}
