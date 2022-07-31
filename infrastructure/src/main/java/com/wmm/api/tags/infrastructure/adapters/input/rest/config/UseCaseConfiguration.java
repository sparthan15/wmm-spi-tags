package com.wmm.api.tags.infrastructure.adapters.input.rest.config;

import com.wmm.api.tags.application.ports.input.CreateTagInputPort;
import com.wmm.api.tags.application.ports.input.DeleteTagInputPort;
import com.wmm.api.tags.application.ports.output.TagOutputPort;
import com.wmm.api.tags.application.usecases.CreateTagUseCase;
import com.wmm.api.tags.application.usecases.DeleteTagUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {

    @Bean
    public CreateTagUseCase createTagUseCase(TagOutputPort tagOutputPort) {
        return new CreateTagInputPort(tagOutputPort);
    }

    @Bean
    public DeleteTagUseCase deleteTagUseCase(TagOutputPort tagOutputPort) {
        return new DeleteTagInputPort(tagOutputPort);
    }


}