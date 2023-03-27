package com.novatlas.livraison.entities;

import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
public class Command {
    private Long idCommand;
    private int numerosCommand;
    private String nomCommand;
    private Double prixTotal;
    private Livraison IdLivraison;

}
