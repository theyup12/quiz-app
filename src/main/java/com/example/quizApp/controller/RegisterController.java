package com.example.quizApp.controller;

import com.example.quizApp.domain.UserRegisterDomain;
import com.example.quizApp.entity.User;
import com.example.quizApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegisterController {
    @Autowired
    private UserService userService;

    @GetMapping("/register-new-user")
    public String showUser(Model model){
        User currentUser = new User();
        model.addAttribute("user", currentUser);
        return "register";
    }

    @PostMapping("/registerUser")
    public String registerUser(@ModelAttribute("user")@Valid UserRegisterDomain userRegisterDomain, Model model){
        userService.saveUser(userRegisterDomain);
        return "redirect:/login";
    }
}
