package com.example.quizApp.controller;

import com.example.quizApp.domain.ContractDomain;
import com.example.quizApp.entity.Contract;
import com.example.quizApp.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ContactController {
    @Autowired
    private ContactService contactService;

    @GetMapping("/contact")
    public String showUser(Model model){
        Contract contract = new Contract();
        model.addAttribute("contract", contract);
        return "contract";
    }

    @PostMapping("/contact")
    public String registerUser(@ModelAttribute("contract")@Valid ContractDomain contractDomain, Model model){
        contactService.saveContract(contractDomain);
        return "redirect:/home";
    }
}
