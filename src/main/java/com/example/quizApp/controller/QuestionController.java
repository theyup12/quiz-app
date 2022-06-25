package com.example.quizApp.controller;

import com.example.quizApp.entity.Question;
import com.example.quizApp.services.CategoryService;
import com.example.quizApp.services.QuestionService;
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
    @GetMapping("/quiz")
    public String listQuestions(@RequestParam("categoryId")Integer categoryId, Model model){
        List<Question> questionsList = questionService.getQuestionsWithType(categoryId);
        model.addAttribute("categoryName", categoryService.getCategoryNameById(categoryId));
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
            return "redirect:/online-quiz/home";
        }else{
            model.addAttribute("index", action);
        }
        return "questions";
    }

//    @PostMapping("/submit-quiz")
//    public String submitQuiz(Model model){
//        String endTime = questionService.getTime();
//
//        return "submit";
//    }
}
