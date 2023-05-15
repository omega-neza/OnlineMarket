package com.project.market.controller;

import com.project.market.model.SignUpForm;
import com.project.market.repository.SignUpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {

    @Autowired
    private SignUpRepository signUpRepository;

    @GetMapping(path="/signup")
    public String getSignUpForm(Model model) {
        model.addAttribute("signUpForm", new SignUpForm());
        return "Signup";
    }

    @PostMapping(path="/signup-submit")
    public String submitSignUp(@ModelAttribute("signUpForm") SignUpForm signUpForm, Model model) {
        signUpRepository.save(signUpForm);
        model.addAttribute("signUpForm", signUpForm);
        return "Login";
    }
    @GetMapping("/")
    public String index() {
        return "Intro";
    }
}
