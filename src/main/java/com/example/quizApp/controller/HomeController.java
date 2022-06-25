package com.example.quizApp.controller;

import com.example.quizApp.entity.Category;
import com.example.quizApp.entity.User;
import com.example.quizApp.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@SessionAttributes({"user"})
@Controller
public class HomeController {
    @Autowired
    private CategoryService categoryService;


    @GetMapping("/home")
    public String homePage(Model model){
        List<Category> categories = categoryService.displayCategory();
        model.addAttribute("categories", categories);
//        User user= (User) model.getAttribute("user");
//        model.addAttribute("user", user);
        return "home";
    }

}
