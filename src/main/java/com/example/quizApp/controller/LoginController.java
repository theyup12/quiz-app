package com.example.quizApp.controller;

import com.example.quizApp.domain.LoginDomain;
import com.example.quizApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String loginPage(Model model){
        LoginDomain currentUser = new LoginDomain();
        model.addAttribute("userLogin", currentUser);
        return "login";
    }
    @PostMapping("/user-login")
    public String userLogin(@ModelAttribute("userLogin")@Valid LoginDomain loginDomain, Model model){
        //check if the email and password valid, and if it is existed
//        boolean isExisted = userService.checkEmail(loginDomain.getEmail());
        return "home";
    }

}
