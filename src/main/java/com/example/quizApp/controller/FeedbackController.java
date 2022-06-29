package com.example.quizApp.controller;

import com.example.quizApp.domain.FeedbackDomain;
import com.example.quizApp.entity.Feedback;
import com.example.quizApp.entity.User;
import com.example.quizApp.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@SessionAttributes({"user"})

@Controller
@RequestMapping("/online-quiz")
public class FeedbackController {
    @Autowired
    FeedbackService feedbackService;

    @GetMapping("/feedback")
    public String showUser(Model model){
        Feedback feedback = new Feedback();
        model.addAttribute("feedback", feedback);
        return "feedback";
    }

    @PostMapping("/feedback")
    public String registerUser(@ModelAttribute("feedback")@Valid FeedbackDomain feedbackDomain, HttpServletRequest request){
        HttpSession oldSession = request.getSession(false);
        User user = (User) oldSession.getAttribute("user");
        feedbackService.submitFeedback(feedbackDomain, user.getUserId());
        return "submit";
    }
}
