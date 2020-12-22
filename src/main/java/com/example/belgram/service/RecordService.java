package com.example.belgram.service;

import com.example.belgram.entity.Record;
import com.example.belgram.entity.security.User;
import com.example.belgram.repository.RecordRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class RecordService {
    RecordRepository recordRepository;

    public RecordService(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    public void saveRecord(Record recordFromForm, User user) {
        recordFromForm.setUser(user);
        recordRepository.save(recordFromForm);
    }
}
