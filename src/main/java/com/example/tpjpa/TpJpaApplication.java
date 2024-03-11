package com.example.tpjpa;

import com.example.tpjpa.dao.entities.Product;
import com.example.tpjpa.dao.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class TpJpaApplication implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(TpJpaApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        Product product1 = new Product(1,"produit 1","p3",40);
        Product product2 = new Product(2,"produit 2","p4",50);
        productRepository.save(product1);
        productRepository.save(product2);


        Product productUpdatedById = productRepository.findById(1L).get();
        System.out.println(productUpdatedById);
        product1.setNom("produitTest");
        productRepository.save(product1);
        productUpdatedById = productRepository.findById(1L).get();
        System.out.println(productUpdatedById);

        System.out.println(productRepository.findById(2L).get());
        productRepository.delete(product2);
        try{
            System.out.println(productRepository.findById(2L).get());

        }catch (Exception exception) {
            System.out.println("product deleted");
        }



    }


}
