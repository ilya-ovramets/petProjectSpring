package com.illia.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class NavigateController {
    @GetMapping
    public String index(Model model) {
        model.addAttribute("message", "Welcome to the public section!");
        return "public/index"; // Шлях до вашого HTML-шаблону
    }

    // Сторінка "About"
    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "About Us");
        model.addAttribute("content", "This is the About page for the public section.");
        return "public/about"; // Шлях до вашого HTML-шаблону
    }

    // Сторінка "Contact"
    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("title", "Contact Us");
        model.addAttribute("content", "This is the Contact page. Feel free to reach out!");
        return "public/contact"; // Шлях до вашого HTML-шаблону
    }

    @RequestMapping("/login")
    public String login(Model model) {
        return "public/login";
    }


}
