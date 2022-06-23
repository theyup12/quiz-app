package com.example.quizApp.controller;

import com.example.quizApp.domain.FeedbackDomain;
import com.example.quizApp.domain.UserRegisterDomain;
import com.example.quizApp.entity.Feedback;
import com.example.quizApp.entity.User;
import com.example.quizApp.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class FeedbackController {
    @Autowired
    FeedbackService feedbackService;

    @GetMapping("/feedback")
    public String showUser(Model model){
        Feedback feedback = new Feedback();
        model.addAttribute("feedback", feedback);
        return "feedback";
    }

//    @PostMapping("/feedback")
//    public String registerUser(@ModelAttribute("feedback")@Valid FeedbackDomain feedbackDomain, Model model){
//        feedbackService.submitFeedback(feedbackDomain);
//        return "feedback";
//    }
}
