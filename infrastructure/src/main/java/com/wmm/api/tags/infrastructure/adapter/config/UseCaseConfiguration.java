package com.wmm.api.tags.infrastructure.adapter.config;

import com.wmm.api.tags.application.ports.output.TagOutputPort;
import com.wmm.api.tags.application.ports.input.CreateTagInputPort;
import com.wmm.api.tags.application.usecases.CreateTagUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {

    @Bean
    public CreateTagUseCase createTagUseCase(TagOutputPort tagOutputPort){
        return new CreateTagInputPort(tagOutputPort);
    }


}
