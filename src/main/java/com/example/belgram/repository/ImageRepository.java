package com.example.belgram.repository;

import com.example.belgram.entity.Record;
import org.springframework.content.commons.repository.ContentStore;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends ContentStore<Record, String> {
}

