package com.bipros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bipros.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT * FROM products WHERE attributes->>'color' = ?1", nativeQuery = true)
    List<Product> findByColor(String color);
    
    
}

