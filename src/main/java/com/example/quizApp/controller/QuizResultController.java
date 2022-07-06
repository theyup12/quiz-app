package com.example.quizApp.controller;

import com.example.quizApp.entity.*;
import com.example.quizApp.services.CategoryService;
import com.example.quizApp.services.QuestionService;
import com.example.quizApp.services.QuizResultService;
import com.example.quizApp.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@SessionAttributes({"user", "categoryList", "quizzes"})
@Controller
@RequestMapping("/online-quiz")
public class QuizResultController {
    @Autowired
    private QuizResultService quizResultService;

    @Autowired
    private QuizService quizService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private QuestionService questionService;
    @GetMapping("/create-report-list")
    public String reportList(Model model){
        User user = ((User)model.getAttribute("user"));
        List<Category> categoryList = categoryService.displayCategory();
        if(user != null){
            List<Quiz> quizzes = quizService.getQuizByUser(user.getUserId());
            model.addAttribute("quizzes", quizzes);
        }
        model.addAttribute("user", user);
        model.addAttribute("categoryList", categoryList);
        return "redirect:/online-quiz/home";
    }
    @GetMapping("/get-quiz-report")
    public String getQuizReport(Model model, @RequestParam Integer quizId){
        Quiz quiz = quizService.getQuizByQuizId(quizId);
        List<QuizResult> quizResultList = quizResultService.getResultList(quizId);
        List<Question> questions = quizResultService.getQuestionList(quizResultList);
        model.addAttribute("quizResultList", quizResultList);
        model.addAttribute("questionList", questions);
        model.addAttribute("quiz", quiz);
        User user = ((User)model.getAttribute("user"));
        model.addAttribute("user", user);
        return "report";
    }
}
