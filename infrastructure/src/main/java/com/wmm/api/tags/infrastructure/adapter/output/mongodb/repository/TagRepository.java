package com.wmm.api.tags.infrastructure.adapter.output.mongodb.repository;

import com.wmm.api.tags.infrastructure.adapter.output.mongodb.entity.TagEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends PagingAndSortingRepository<TagEntity, String> {

    Page<TagEntity> findByUserId(String userId, Pageable pageable);
}
