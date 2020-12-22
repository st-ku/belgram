package com.example.belgram.controller;

import com.example.belgram.entity.Record;
import com.example.belgram.entity.security.User;
import com.example.belgram.service.RecordService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.sql.SQLException;

@Controller
@Data
public class RecordController {
    private RecordService recordService;

    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    @GetMapping(value = "/")
    public String main() {
        return "main";
    }

    @GetMapping(value = "/add")
    public String addRecord() {
        return "add";
    }

    @PostMapping(value = "/new")
    public String createRecord(@Valid Record recordFromForm, @RequestParam(required = false) MultipartFile[] fileUpload) throws SQLException, IOException {
        User user = (User) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        if (fileUpload != null) {
           // recordFromForm.getImageFiles().add(handleFileUpload(fileUpload));
        }
        recordService.saveRecord(recordFromForm, user);
        return "redirect:/";
    }
}
