package com.example.BooKStroreApplication.Service;

import com.example.BooKStroreApplication.Model.Cart;
import com.example.BooKStroreApplication.Repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository; // Inject CartRepository

    // Method to save a cart item
    public void addMyBooks(Cart myBook) {
        cartRepository.save(myBook); // Use the save method from CartRepository
    }

    // Method to get all cart items
    public List<Cart> getAllBooks() {
        return cartRepository.findAll(); // Use findAll() from CartRepository
    }

    // Method to delete a cart item by ID
    public void deleteById(int id) {
        cartRepository.deleteById(id); // Use deleteById() from CartRepository
    }
}
