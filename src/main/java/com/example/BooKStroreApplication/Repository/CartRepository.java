package com.example.BooKStroreApplication.Repository;

import com.example.BooKStroreApplication.Model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    // Inherits CRUD operations from JpaRepository
}
