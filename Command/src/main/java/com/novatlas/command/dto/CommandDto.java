package com.novatlas.command.dto;

import com.novatlas.command.entities.Produit;

import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor @AllArgsConstructor @Data
public class CommandDto {

    private Long id;
    private int numerosCommand;
    private String nomCommand;
    private Double prixTotal;

    private List<ProduitDto> products;
}
