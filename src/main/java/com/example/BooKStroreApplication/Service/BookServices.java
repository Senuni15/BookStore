package com.example.BooKStroreApplication.Service;

import com.example.BooKStroreApplication.Model.Book;
import com.example.BooKStroreApplication.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServices { // Renamed this to BookServices to match the original name

    @Autowired
    private BookRepository bRepo;

    public void save(Book b) {
        bRepo.save(b);
    }

    public List<Book> getAllBook() {
        return bRepo.findAll();
    }

    public Book getBookById(int id) {
        return bRepo.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        bRepo.deleteById(id);
    }

}
