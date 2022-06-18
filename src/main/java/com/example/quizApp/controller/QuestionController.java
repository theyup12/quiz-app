package com.example.quizApp.controller;

import com.example.quizApp.entity.Question;
import com.example.quizApp.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("/questions")
    public String listQuestions(@RequestParam("categoryId")Integer categoryId, Model model){
        List<Question> theQuestions = questionService.getQuestionsWithType(categoryId);
        model.addAttribute("questions", theQuestions);
        return "questions";
    }
}
