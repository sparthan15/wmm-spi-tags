package com.wmm.api.tags.application.usecases;

import com.wmm.api.tags.domain.entities.Tag;

public interface CreateTagUseCase {

    Tag execute(Tag tag);
}
