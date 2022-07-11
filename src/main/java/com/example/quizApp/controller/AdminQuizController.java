package com.example.quizApp.controller;

import com.example.quizApp.entity.*;
import com.example.quizApp.services.CategoryService;
import com.example.quizApp.services.QuizResultService;
import com.example.quizApp.services.QuizService;
import com.example.quizApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminQuizController {
    @Autowired
    private QuizService quizService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserService userService;

    @Autowired
    private QuizResultService quizResultService;

    @GetMapping("overview-quiz")
    public String overviewQuiz(Model model){
        List<Category> categoryList = categoryService.displayCategory();
        List<Quiz> quizzes = quizService.getAllQuiz();
        quizzes.sort((q1, q2) -> q2.getStartTime().compareTo(q1.getStartTime()));
        List<User> userList = userService.findUser();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("quizzes", quizzes);
        model.addAttribute("userList", userList);
        return "adminQuiz";
    }
    @GetMapping("overview-quiz-report")
    public String quizReport(Model model, @RequestParam int quizId, @RequestParam int userId){
        Quiz quiz = quizService.getQuizByQuizId(quizId);
        List<QuizResult> quizResultList = quizResultService.getResultList(quizId);
        List<Question> questions = quizResultService.getQuestionList(quizResultList);
        model.addAttribute("quizResultList", quizResultList);
        model.addAttribute("questionList", questions);
        model.addAttribute("quiz", quiz);
        User user = userService.findUserByUserId(userId);
        model.addAttribute("user", user);
        return "report";
    }
}
