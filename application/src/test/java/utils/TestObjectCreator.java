package utils;

import com.wmm.api.tags.domain.entities.Tag;
import com.wmm.api.tags.domain.entities.ThresholdLimit;

public class TestObjectCreator {

    public static final String RAPPI_TAG = "RAPPI";
    public static final String USER_ID_TEST = "123KDASF";

    public static Tag createTagToInsert(ThresholdLimit thresholdLimit){
        return Tag.builder()
                .name(RAPPI_TAG)
                .description("xxxx")
                .thresholdLimit(thresholdLimit)
                .userId(USER_ID_TEST)
                .build();
    }
    public static Tag insertedTag(ThresholdLimit thresholdLimit){
        Tag tagToInser = createTagToInsert(thresholdLimit);
        return Tag.builder()
                .id("KASDJ")
                .name(tagToInser.getName())
                .description(tagToInser.getDescription())
                .thresholdLimit(tagToInser.getThresholdLimit())
                .userId(tagToInser.getUserId())
                .build();
    }

}
