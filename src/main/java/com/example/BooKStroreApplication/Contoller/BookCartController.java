package com.example.BooKStroreApplication.Contoller;

import com.example.BooKStroreApplication.Model.User;
import  com.example.BooKStroreApplication.Service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookCartController {

    @Autowired // Dependency Injection
    private CartService Service; // Service class object

    @RequestMapping("/removeBook/{id}")
    public String removeBook(@PathVariable("id") int id) {
        Service.deleteById(id);  // Call to remove the book from the cart
        return "redirect:/Cart";  // Redirect back to the cart page
    }


}