package com.novatlas.command.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Produit {
    private Long idProduit;

    private String nomProduit;

    private Double prixProduit;

    private Long commndId;


}
