package com.example.quizApp.controller;

import com.example.quizApp.entity.Category;
import com.example.quizApp.entity.Question;
import com.example.quizApp.entity.Quiz;
import com.example.quizApp.entity.User;
import com.example.quizApp.services.CategoryService;
import com.example.quizApp.services.QuestionService;
import com.example.quizApp.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SessionAttributes({"questionsList", "index", "answerArray", "startTime"})
@Controller
@RequestMapping("/online-quiz")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private QuizService quizService;
    @GetMapping("/quiz")
    public String listQuestions(@RequestParam("categoryId")Integer categoryId, Model model){
        List<Question> questionsList = questionService.getQuestionsWithType(categoryId);
        model.addAttribute("category", categoryService.getCategoryById(categoryId));
        model.addAttribute("questionsList", questionsList);
        model.addAttribute("index", 0);
        model.addAttribute("answerArray", new Integer[10]);
        model.addAttribute("startTime", questionService.getTime());
        return "questions";
    }
    @PostMapping("/quiz")
    public String nextQuizQuestion(@RequestParam("action") String action,
                                   @RequestParam("input") Optional<Integer> input, @RequestParam Integer index, Model model){
        Integer[] answer = (Integer[]) model.getAttribute("answerArray");
        if(input.isPresent()){
            assert answer != null;
            answer[index] = input.orElseGet(()-> null);
        }
        System.out.println(Arrays.toString(answer));
        model.addAttribute("answerArray", answer);
        if(action.equals("previous")){
            model.addAttribute("index", index - 1);
        }else if(action.equals("next")){
            model.addAttribute("index", index + 1);
        }else if(action.equals("finish")) {
            return "redirect:/online-quiz/submit-quiz";
        }else{
            model.addAttribute("index", action);
        }
        return "questions";
    }

    @PostMapping("/submit-quiz")
    public String submitQuiz(@RequestParam("category") Category category, Model model){
        String endTime = questionService.getTime();
        Integer userId = ((User)model.getAttribute("user")).getUserId();
        Integer categoryId = category.getCategoryId();
        String startTime = (String)model.getAttribute("startTime");
        quizService.saveQuiz(userId, categoryId, startTime, endTime);
        return "submit";
    }
}
