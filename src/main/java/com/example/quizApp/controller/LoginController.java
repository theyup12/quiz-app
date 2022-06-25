package com.example.quizApp.controller;

import com.example.quizApp.domain.LoginDomain;
import com.example.quizApp.entity.User;
import com.example.quizApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
@SessionAttributes({"user"})
@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String mainPage(HttpServletRequest request, Model model){
        HttpSession oldSession = request.getSession(false);
        if(oldSession != null){
            if(oldSession.getAttribute("user") != null){
                return "redirect:/online-quiz/home";
            }else{
                model.addAttribute("error", "");
                model.addAttribute("userLogin", new LoginDomain());
                return "login";
            }
        }else{
            model.addAttribute("error", "");
            model.addAttribute("userLogin", new LoginDomain());
            return "login";
        }
    }
    @GetMapping("/user-login")
    public String loginPage(Model model){
        model.addAttribute("userLogin", new LoginDomain());
        model.addAttribute("error", "");
        return "login";
    }
    @PostMapping("/user-login")
    public String userLogin(HttpServletRequest request, @ModelAttribute("userLogin")@Valid LoginDomain loginDomain, Model model){
        HttpSession oldSession = request.getSession(false);
        if(userService.checkUserByEmail(loginDomain.getEmail())) {
            User user = userService.checkLogin(loginDomain);
            if (user != null && user.getIsActive() == (byte) 1) {
                if (oldSession != null) {
                    oldSession.invalidate();
                }
                HttpSession newSession = request.getSession(true);
                newSession.setAttribute("user", user);
                model.addAttribute("user", user);
                return "redirect:/online-quiz/home";
            } else{
                if (oldSession != null) {
                    oldSession.invalidate();
                }
                model.addAttribute("userLogin", new LoginDomain());
                if(user != null && user.getIsActive() == (byte) 0){
                    model.addAttribute("error", "* You do not have permission to login");
                }else{
                    model.addAttribute("error", "* Email and Password do not match");
                }
                return "login";
            }
        }else{
            model.addAttribute("userLogin", new LoginDomain());
            model.addAttribute("error", "* Email does not exist");
            return "login";
        }
    }
    @GetMapping("/logout")
    public String logOut(HttpServletRequest request, SessionStatus sessionStatus){
        sessionStatus.setComplete();
        HttpSession oldSession = request.getSession(false);
        if(oldSession != null){
            oldSession.invalidate();
        }
        return "redirect:/";
    }
}
