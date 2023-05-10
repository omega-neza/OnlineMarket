package com.project.market.controller;

import com.project.market.model.SignUpForm;
import com.project.market.repository.SignUpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private SignUpRepository signUpRepository;

    @GetMapping("/login")
    public String login() {
        return "Login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {

        if(email.equals("admin@gmail.com") && password.equals("i am the Admin")) {
            return "AdminBoard";
        }

        SignUpForm signUpForm = signUpRepository.findByEmailAndPassword(email, password);

        if (signUpForm != null) {
            return "Home";
        } else {
            model.addAttribute("error", "Invalid email or password!");
            return "Login";
        }
    }
}
