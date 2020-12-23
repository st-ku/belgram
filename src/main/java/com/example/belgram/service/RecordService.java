package com.example.belgram.service;

import com.example.belgram.entity.Record;
import com.example.belgram.entity.security.User;
import com.example.belgram.repository.ImageRepository;
import com.example.belgram.repository.RecordRepository;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class RecordService {
    private RecordRepository recordRepository;
    private ImageRepository imageRepository;

    public RecordService(RecordRepository recordRepository, ImageRepository imageRepository) {
        this.recordRepository = recordRepository;
        this.imageRepository = imageRepository;
    }

    public void saveRecord(Record recordFromForm, User user, MultipartFile[] imageUpload) throws IOException {
        recordFromForm.setUser(user);
        for (MultipartFile file:imageUpload) {
            InputStream inputStream =  new BufferedInputStream(file.getInputStream());
            imageRepository.setContent(recordFromForm,inputStream);
        }
        recordRepository.save(recordFromForm);
    }
}
