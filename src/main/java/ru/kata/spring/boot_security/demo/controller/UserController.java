package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    public String user(Model model, Principal principal) {
        model.addAttribute("user", userService.loadUserByUsername(principal.getName()));

        return "user";
    }

    @RequestMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("users", userService.getAllUsers());

        return "admin";
    }

    @RequestMapping("/add")
    public String addNewUser(Model model) {
        model.addAttribute("user", new User());

        return "user-info";
    }

    @RequestMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);

        return "redirect:/admin";
    }

    @RequestMapping("/updateInfo")
    public String updateUser (@RequestParam("userId") long id, Model model) {
        model.addAttribute("user", userService.getUser(id));

        return "user-info";
    }
    @RequestMapping("/deleteUser")
    public String deleteUser (@RequestParam("userId") long id) {
        userService.deleteUser(id);

        return "redirect:/admin";
    }

}
