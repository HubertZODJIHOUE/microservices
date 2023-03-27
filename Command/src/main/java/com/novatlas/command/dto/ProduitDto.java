package com.novatlas.command.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ProduitDto {
    private String nomProduit;

    private Double prixProduit;
}
