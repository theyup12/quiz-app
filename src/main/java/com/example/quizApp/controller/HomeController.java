package com.example.quizApp.controller;

import com.example.quizApp.entity.Category;
import com.example.quizApp.entity.User;
import com.example.quizApp.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@SessionAttributes({"user"})
@Controller
@RequestMapping("/online-quiz")
public class HomeController {
    @Autowired
    private CategoryService categoryService;


    @GetMapping("/home")
    public String homePage(HttpServletRequest request, Model model){
        HttpSession oldSession = request.getSession(false);
        List<Category> categories = categoryService.displayCategory();
        model.addAttribute("categories", categories);
        User user = (User) oldSession.getAttribute("user");
        model.addAttribute("user", user);
        model.addAttribute("userName", user.getFirstName());
        return "home";
    }

}
