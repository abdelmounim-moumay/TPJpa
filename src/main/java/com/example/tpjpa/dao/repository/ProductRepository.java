package com.example.tpjpa.dao.repository;

import com.example.tpjpa.dao.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {


    public List<Product> findBynom(String nom);
    public List<Product> findDescription(String Description);
    public List<Product> findByPrix(double prix);

}
