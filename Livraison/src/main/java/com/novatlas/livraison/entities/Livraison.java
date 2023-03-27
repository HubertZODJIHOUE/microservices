package com.novatlas.livraison.entities;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity @AllArgsConstructor @NoArgsConstructor @Data
public class Livraison {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Date dateLivraison;
    @Transient
    private List<Command> commands;

    private String nomLivreur;
}
