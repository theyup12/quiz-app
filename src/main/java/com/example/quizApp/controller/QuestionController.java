package com.example.quizApp.controller;

import com.example.quizApp.entity.*;
import com.example.quizApp.services.CategoryService;
import com.example.quizApp.services.QuestionService;
import com.example.quizApp.services.QuizResultService;
import com.example.quizApp.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SessionAttributes({"user", "questionsList", "index", "answerArray", "startTime", "category"})
@Controller
@RequestMapping("/online-quiz")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private QuizResultService quizResultService;
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
                                   @RequestParam("input") Optional<Integer> input,
                                   @RequestParam Integer index, Model model){
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
    @GetMapping("/submit-quiz")
    public String submitQuiz(Model model){
        String endTime = questionService.getTime();
        Integer userId = ((User)model.getAttribute("user")).getUserId();
        Integer categoryId = ((Category)model.getAttribute("category")).getCategoryId();
        String startTime = (String)model.getAttribute("startTime");
        Quiz quiz = quizService.saveQuiz(userId, categoryId, startTime, endTime);
        List<Question> questions = (List<Question>) model.getAttribute("questionsList");
        Integer[] answerArray = (Integer[]) model.getAttribute("answerArray");
        quizResultService.saveQuizResult(quiz.getQuizId(), questions, answerArray);
        System.out.println(questions);
        System.out.println(Arrays.toString(answerArray));


        return "submit";
    }
}
