package com.wmm.api.tags.infrastructure.adapter.output.mongodb.repository;

import com.wmm.api.tags.infrastructure.adapter.output.mongodb.entity.TagEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends MongoRepository<TagEntity, String> {

    List<TagEntity> findByUserId(long userId);
}
