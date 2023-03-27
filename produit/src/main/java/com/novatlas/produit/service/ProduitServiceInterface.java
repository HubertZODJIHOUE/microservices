package com.novatlas.produit.service;

import com.novatlas.produit.dto.ProduitDTO;
import com.novatlas.produit.exceptions.ProduitNotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProduitServiceInterface {
    ResponseEntity<List<ProduitDTO>> getAllProducts();

    ResponseEntity<ProduitDTO> getProductById(Long idProduit) throws ProduitNotFoundException;

    ResponseEntity<ProduitDTO> createProduct(ProduitDTO produitDTO);

    ResponseEntity<ProduitDTO> updateProduct(Long idProduct, ProduitDTO produitDTO) throws ProduitNotFoundException;

    ResponseEntity<Void> deleteProduct(Long idProduct) throws ProduitNotFoundException;

}
