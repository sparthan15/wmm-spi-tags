package com.wmm.tickets.infrastructure.adapters.input.rest;

import com.wmm.api.tags.infrastructure.adapter.TagsApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes =
        TagsApplication.class)
@AutoConfigureMockMvc
public class GetTagEndpointTest {

    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper objectMapper = new ObjectMapper();
    private String apiUri = "/tags";

    @Test
    public void testGetTagsByUserId() throws Exception {
        mockMvc.perform(get(apiUri)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
