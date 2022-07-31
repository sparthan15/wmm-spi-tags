package com.wmm.tickets.infrastructure.adapters.input.rest;

import com.wmm.api.tags.infrastructure.adapter.TagsApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes =
        TagsApplication.class)
@AutoConfigureMockMvc
public class TagEndpointTest {

    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper objectMapper = new ObjectMapper();
    private String apiUri = "/tags";

    @Test
    void savingANewTag() throws Exception {
        mockMvc.perform(post(apiUri)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"name\": \"TD\",\n" +
                        "    \"amount\": 0,\n" +
                        "    \"description\": \"Movimientos pagados con la tarjeda debito\",\n" +
                        "    \"period\": \"NO_LIMIT\",\n" +
                        "    \"userId\": \"1\"\n" +
                        "}")
        ).andExpect(status().isOk());
    }

    @Test
    void deleteTag() throws Exception {
        mockMvc.perform(delete(apiUri + "?tagId=12312jlk13")
        ).andExpect(status().isOk());
    }


}