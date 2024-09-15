package com.example.BooKStroreApplication.Repository;

import com.example.BooKStroreApplication.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // Optional: You can add custom query methods if needed, like finding by username
    User findByName(String name);
}
