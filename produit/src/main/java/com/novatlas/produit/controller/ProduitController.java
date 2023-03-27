package com.novatlas.produit.controller;

import com.novatlas.produit.dto.ProduitDTO;
import com.novatlas.produit.entities.Produit;
import com.novatlas.produit.exceptions.ProduitNotFoundException;
import com.novatlas.produit.repository.ProduitRepository;
import com.novatlas.produit.service.ProduitServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/products")
public class ProduitController {
    @Autowired
    ProduitServiceImplementation produitServiceImplementation;
    @Autowired
    private ProduitRepository produitRepository;

    @GetMapping()
    public ResponseEntity<List<ProduitDTO>> getAllProducts()
    {
        return produitServiceImplementation.getAllProducts();
    }

    @GetMapping("/{idProduit}")
    public ResponseEntity<ProduitDTO> getProductById(@PathVariable Long idProduit) throws ProduitNotFoundException {
        return produitServiceImplementation.getProductById(idProduit);
    }

    @PostMapping()
    public ResponseEntity<ProduitDTO> createProduct(@RequestBody ProduitDTO produitDTO) {
        return produitServiceImplementation.createProduct(produitDTO);
    }

    @PutMapping("/{idProduit}")
    public ResponseEntity<ProduitDTO> updateProduct(@PathVariable Long idProduit, @RequestBody ProduitDTO produitDTO) throws ProduitNotFoundException {
        return produitServiceImplementation.updateProduct(idProduit, produitDTO);
    }

    @DeleteMapping("/{idProduit}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long idProduit) throws ProduitNotFoundException {
        return produitServiceImplementation.deleteProduct(idProduit);
    }


//    @GetMapping()
//    public List<Produit> getAllProduct(){
//        return  produitRepository.findAll();
//    }
//
//    @GetMapping(path = "/{idProduct}")
//    public  Produit getProduc(@PathVariable(name = "idProduct") Long idProduit){
//        return produitRepository.findById(idProduit).get();
//    }
//
//    @PostMapping()
//    public  Produit save(@RequestBody Produit chantier){
//        return produitRepository.save(chantier);
//    }
//
//
//    @DeleteMapping(path = "/{idProduct}")
//    public  void delete(@PathVariable Long id){
//        produitRepository.deleteById(id);
//    }



}
