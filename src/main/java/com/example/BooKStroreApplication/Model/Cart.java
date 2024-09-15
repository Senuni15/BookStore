package com.example.BooKStroreApplication.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cart")
public class Cart {

    @Id
    private int id;
    private String name;
    private String author;
    private String type;
    private String price;

    // Constructor with parameters
    public Cart(int id, String name, String author, String type, String price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.type = type;
        this.price = price;
    }

    // Default constructor
    public Cart() {
        super();
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
