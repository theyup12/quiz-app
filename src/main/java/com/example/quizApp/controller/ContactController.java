package com.example.quizApp.controller;

import com.example.quizApp.domain.ContactDomain;
import com.example.quizApp.entity.Contact;
import com.example.quizApp.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/online-quiz")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @GetMapping("/contact")
    public String showUser(Model model){
        Contact contact = new Contact();
        model.addAttribute("contact", contact);
        return "contact";
    }

    @PostMapping("/contact")
    public String registerUser(@ModelAttribute("contact")@Valid ContactDomain contactDomain, Model model){
        contactService.saveContact(contactDomain);
        return "redirect:/online-quiz/home";
    }
}
