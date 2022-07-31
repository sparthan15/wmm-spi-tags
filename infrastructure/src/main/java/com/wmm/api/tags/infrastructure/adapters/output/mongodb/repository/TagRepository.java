package com.wmm.api.tags.infrastructure.adapters.output.mongodb.repository;

import com.wmm.api.tags.infrastructure.adapters.output.mongodb.entity.TagEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends PagingAndSortingRepository<TagEntity, String> {

    Page<TagEntity> findByUserId(String userId, Pageable pageable);
}