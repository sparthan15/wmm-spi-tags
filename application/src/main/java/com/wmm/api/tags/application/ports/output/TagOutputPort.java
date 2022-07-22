package com.wmm.api.tags.application.ports.output;

import com.wmm.api.tags.domain.entities.Tag;

public interface TagOutputPort {

    Tag create(Tag tag);
}
