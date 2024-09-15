package com.example.BooKStroreApplication.Contoller;


import com.example.BooKStroreApplication.Model.Cart;
import com.example.BooKStroreApplication.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.BooKStroreApplication.Model.Book;
import com.example.BooKStroreApplication.Service.BookServices;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookServices service; // Creating object of BookService class

    @Autowired
    private CartService cartService; // Creating object of the CartService

    @GetMapping("/")
    public String Login()
    {
        return "UserLogin";
    }
    @GetMapping("/register")
    public String showRegisterForm() {
        return "UserRegister"; // This should map to UserRegister.html in the templates folder
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/book_register")
    public String bookRegister() {
        return "bookRegister";
    }

    @GetMapping("/available_books")
    public ModelAndView getAllBook() {
        List<Book> books = service.getAllBook(); // Fetch all books from the service
        ModelAndView m = new ModelAndView();
        m.setViewName("availableBooks"); // Set the view name to the Thymeleaf template
        m.addObject("books", books); // Add the list of books to the model
        return new ModelAndView("availableBooks", "books", books);
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book b) {
        service.save(b); // Save the book entity
        return "redirect:/available_books"; // Redirect to available books page
    }

    // View get data in the cart
    @GetMapping("/Cart")
    public String Cart(Model model) {
        List<Cart> list = cartService.getAllBooks();
        model.addAttribute("books", list); // Changed from "book" to "books"
        return "Cart";
    }


    // Add available books to the cart using ID
    @RequestMapping("/booklist/{id}")
    public String getBookList(@PathVariable("id") int id) {
        Book b = service.getBookById(id);
        Cart cart = new Cart(b.getId(), b.getName(), b.getAuthor(), b.getType(), b.getPrice()); // Creating Cart object
        cartService.addMyBooks(cart);
        return "redirect:/Cart";
    }

    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id,Model model)
    {
      Book b =service.getBookById(id);
      model.addAttribute("book",b);
        return "bookEdit";
    }

    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id")int id) {
        service.deleteById(id);
        return "redirect:/available_books";
    }
}