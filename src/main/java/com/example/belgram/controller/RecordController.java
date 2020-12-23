package com.example.belgram.controller;

import com.example.belgram.entity.Record;
import com.example.belgram.entity.security.User;
import com.example.belgram.repository.ImageRepository;
import com.example.belgram.repository.UserRepository;
import com.example.belgram.service.RecordService;
import lombok.Data;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Optional;

@Controller
@Data
public class RecordController {
    private RecordService recordService;
    private ImageRepository imageRepository;
    private UserRepository userRepository;

    public RecordController(RecordService recordService, ImageRepository imageRepository, UserRepository userRepository) {
        this.recordService = recordService;
        this.imageRepository = imageRepository;
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/")
    public String main(Model model) {
        model.addAttribute("userList", userRepository.findAll());
        return "main";
    }

    @GetMapping(value = "/add")
    public String addRecord() {
        return "add";
    }

    @GetMapping(value = "/profile/{username}")
    public String viewProfile(@PathVariable("username") String username, Model model) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            model.addAttribute("currentUser", user.get());
            model.addAttribute("userRecords", user.get().getUserRecords());
            return "profile";
        }
        return "main";

    }
    @GetMapping(value = "/profile/{username}/{recordId}")
    public String viewRecord(@PathVariable("username") User user, @PathVariable("recordId") Record record, Model model) {
        model.addAttribute("currentUser", user);
        model.addAttribute("currentRecord", record);
        return "record";
    }

    @PostMapping(value = "/new")
    public String createRecord(@Valid Record recordFromForm, @RequestParam(required = false) MultipartFile[] fileUpload) throws IOException {
        User user = (User) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        recordService.saveRecord(recordFromForm, user,fileUpload);
        return "redirect:/";
    }

}
