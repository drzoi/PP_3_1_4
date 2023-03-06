package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.services.UserService;
import java.security.Principal;

@Controller
@RequestMapping()
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("user")
    public String index(Principal principal, Model model) {
        model.addAttribute("user", userService.findByFirstname(principal.getName()));
        return "UserPage";
    }
}
