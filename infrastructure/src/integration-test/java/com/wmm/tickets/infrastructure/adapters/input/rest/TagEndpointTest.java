package com.wmm.tickets.infrastructure.adapters.input.rest;

import com.wmm.api.tags.infrastructure.adapter.TagsApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static util.TestUtil.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes =
        TagsApplication.class)
@AutoConfigureMockMvc
public class TagEndpointTest {

    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper objectMapper = new ObjectMapper();
    private String apiUri = "/tags";



    @Test
    void  savingANewTag() throws Exception {
        mockMvc.perform(post(apiUri+"/incomes")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"userId\":\""+ USER_ID_TEST +"\"\n" +
                        "    \"startDate\":\"asdasd\"\n" +
                        "    \"endDate\":\""+ END_DATE +"\"\n" +
                        "}")
        ).andExpect(status().isBadRequest());
    }

    @Test
    void  outcomesTicketRequestWithOutEndDateReturnBadRequest() throws Exception {
        mockMvc.perform(post(apiUri+"/incomes")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"userId\":\""+ USER_ID_TEST +"\"\n" +
                        "    \"startDate\":\""+START_DATE+"\"\n" +
                        "    \"endDate\":\"asdadas\"\n" +
                        "}")
        ).andExpect(status().isBadRequest());
    }

}
