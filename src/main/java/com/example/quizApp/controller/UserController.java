package com.example.quizApp.controller;

import com.example.quizApp.entity.User;
import com.example.quizApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/list-user")
    public String findAllUser(Model model){
        List<User> theUsers = userService.findUser();
        model.addAttribute("users", theUsers);
        return "list-users";
    }
}
