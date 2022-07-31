package com.wmm.api.tags.infrastructure.adapters.ouput.mongodb;

import com.wmm.api.tags.infrastructure.adapter.TagsApplication;
import com.wmm.tickets.infrastructure.adapters.model.response.TicketResponse;
import com.wmm.api.tags.infrastructure.adapter.output.mongodb.entity.TagEntity;
import com.wmm.api.tags.infrastructure.adapter.output.mongodb.repository.TagRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
import static util.TestUtil.USER_ID_TEST;

@SpringBootTest(classes = TagsApplication.class)
public class MongoTemplateTest {

    @Autowired
    private TagRepository tagRepository;

    @Test
    public void test(@Autowired MongoTemplate mongoTemplate) {
        assertThat(tagRepository).isNotNull();
        assertThat(mongoTemplate).isNotNull();
    }

    @Test
    public void testGroupAndSumValues(@Autowired MongoTemplate mongoTemplate) {
        GroupOperation groupOperationSum = group("userId")
                .sum("amount")
                .as("amount");
        MatchOperation matchOperation = match(new Criteria("userId")
                .is(USER_ID_TEST));

        Aggregation aggregation = newAggregation(
                matchOperation, groupOperationSum);

        AggregationResults<TicketResponse> response = mongoTemplate.aggregate(aggregation,

                "movements"
                , TicketResponse.class);

        System.out.println(response.getMappedResults());
    }

    @Test
    public void test2(@Autowired MongoTemplate mongoTemplate) {
        Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(USER_ID_TEST));
        mongoTemplate.find(query, TagEntity.class, "tags");
    }

}