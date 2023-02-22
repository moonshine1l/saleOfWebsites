package ru.moonshine1l.saleOfWebsites.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/personal_account")
    public String description(Model model){
        model.addAttribute("title", "Описание продукта");
        return "personal_account";
    }
}
