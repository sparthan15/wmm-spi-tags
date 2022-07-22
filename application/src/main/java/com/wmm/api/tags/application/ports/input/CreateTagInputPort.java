package com.wmm.api.tags.application.ports.input;

import com.wmm.api.tags.application.ports.output.TagOutputPort;
import com.wmm.api.tags.application.usecases.CreateTagUseCase;
import com.wmm.api.tags.domain.entities.Tag;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateTagInputPort implements CreateTagUseCase {

    private final TagOutputPort tagOutputPort;

    @Override
    public Tag execute(Tag tag) {
        return tagOutputPort.create(tag);
    }
}
