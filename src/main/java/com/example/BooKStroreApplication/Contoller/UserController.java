package com.example.BooKStroreApplication.Contoller;

import com.example.BooKStroreApplication.Model.User;
import com.example.BooKStroreApplication.Service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private Userservice userService;



    @PostMapping("/submitRegistration")
    public String registerUser(@ModelAttribute User user, Model model) {
        // Debugging line to print user details
        System.out.println("Received User: " + user.getName() + ", Password: " + user.getPassword());

        // Save user using the service layer
        userService.save(user);

        // Add a success message to the model
        model.addAttribute("message", "Registration successful!");

        // Redirect to the login page after successful registration (or to another page)
        return "UserLogin";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam("name") String name, @RequestParam("password") String password, Model model)
    {
        User user = userService.findByName(name);

        if (user != null && user.getPassword().equals(password))
        {
            // If login is successful, redirect to the home page
            return "redirect:/home";
        }
        else
        {
            // If login fails, display an error message
            model.addAttribute("error", "Invalid username or password!");
            return "UserLogin";
        }
    }




}