package com.example.quizApp.controller;

import com.example.quizApp.entity.Choice;
import com.example.quizApp.entity.Question;
import com.example.quizApp.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;
@SessionAttributes({"questionsList", "index"})
@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("/quiz")
    public String listQuestions(@RequestParam("categoryId")Integer categoryId, Model model){
        List<Question> questionsList = questionService.getQuestionsWithType(categoryId);
        model.addAttribute("questionsList", questionsList);
        model.addAttribute("index", 0);
        return "questions";
    }
    @PostMapping("/quiz")
    public String nextQuizQuestion(@RequestParam("action") String action, @RequestParam Integer index, Model model){
        model.addAttribute("index", action);
        return "questions";
    }
}
