package com.example.belgram.controller;
import com.example.belgram.entity.security.User;
import com.example.belgram.service.UserService;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
@Controller
@Data
@RequestMapping("/registration")
public class RegisterController {
    UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String registration() {
        return "registration";
    }

    @PostMapping("/send")

    public String addUser(@Valid User userForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())) {
            model.addAttribute("passwordConfirmError", "Password isn't match");
            return "registration";
        }
        if (!userService.saveNewUser(userForm)) {
            model.addAttribute("usernameError", "User with this Username Already Exists");
            return "registration";
        }


        return "redirect:/";
    }
}
