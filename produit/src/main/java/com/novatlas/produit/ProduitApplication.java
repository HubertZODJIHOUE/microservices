package com.novatlas.produit;

import com.novatlas.produit.entities.Produit;
import com.novatlas.produit.repository.ProduitRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProduitApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProduitApplication.class, args);
    }
    @Bean
    CommandLineRunner start(ProduitRepository produitRepository){
        return args -> {
            Produit produit= new Produit(null ,"bic", 12.3);
            Produit produit1= new Produit(null ,"cahier",13.2);
            Produit produit2= new Produit(null ,"crayon",47.0);
            Produit produit3= new Produit(null ,"stylo",14.2);
            produitRepository.save(produit3);
            produitRepository.save(produit1);
            produitRepository.save(produit2);
            produitRepository.save(produit);
        };
    }
}
