package com.wmm.api.tags.application.ports.input;

import com.wmm.api.tags.application.ports.output.TagOutputPort;
import com.wmm.api.tags.application.usecases.DeleteTagUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteTagInputPort implements DeleteTagUseCase {

    private final TagOutputPort tagOutputPort;

    @Override
    public void execute(String tagId) {
        tagOutputPort.delete(tagId);
    }
}
