package com.wmm.api.tags.application.usecases;

import com.wmm.api.tags.domain.entities.Tag;

import java.util.List;

public interface GetTagsUseCase {
    List<Tag> getTagsByUserId(String user_id);
}
