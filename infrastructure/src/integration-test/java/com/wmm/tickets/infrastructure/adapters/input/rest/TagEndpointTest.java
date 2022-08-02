package com.wmm.tickets.infrastructure.adapters.input.rest;

import com.wmm.api.tags.infrastructure.TagsApplication;
import com.wmm.api.tags.infrastructure.adapters.input.rest.model.response.TagResponse;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes =
        TagsApplication.class)
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TagEndpointTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    private String apiUri = "/tags";

    private TagResponse insertedTag;

    @Test
    @Order(1)
    void savingANewTag() throws Exception {
        MvcResult result = mockMvc.perform(post(apiUri)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"name\": \"TD\",\n" +
                                "    \"amount\": 0,\n" +
                                "    \"description\": \"Movimientos pagados con la tarjeda debito\",\n" +
                                "    \"period\": \"NO_LIMIT\",\n" +
                                "    \"userId\": \"1\"\n" +
                                "}")
                ).andExpect(status().isOk())
                .andReturn();
        String jsonResult = result.getResponse().getContentAsString();
        insertedTag = new ObjectMapper().readValue(jsonResult, TagResponse.class);

    }

    @Test
    @Order(2)
    void deleteTag() throws Exception {
        MvcResult result = mockMvc.perform(post(apiUri)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"name\": \"TD\",\n" +
                                "    \"amount\": 0,\n" +
                                "    \"description\": \"Movimientos pagados con la tarjeda debito\",\n" +
                                "    \"period\": \"NO_LIMIT\",\n" +
                                "    \"userId\": \"1\"\n" +
                                "}")
                ).andExpect(status().isOk())
                .andReturn();
        String jsonResult = result.getResponse().getContentAsString();
        insertedTag = new ObjectMapper().readValue(jsonResult, TagResponse.class);
        
        mockMvc.perform(delete(apiUri + "?tagId=" + insertedTag.getId())
        ).andExpect(status().isOk());
    }


}