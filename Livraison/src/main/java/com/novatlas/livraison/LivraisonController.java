package com.novatlas.livraison;

import com.novatlas.livraison.entities.Livraison;
import com.novatlas.livraison.repository.LivraisonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class LivraisonController {

    @Autowired
    private LivraisonRepository livraisonRepository;

    @GetMapping(path = "/livraisons")
    public List<Livraison> getAllCommands(){
        return  livraisonRepository.findAll();
    }

    @GetMapping(path = "/livraisons/{idLivraison}")
    public  Livraison getCommand(@PathVariable(name = "idLivraison") Long idLivraison){
        return livraisonRepository.findById(idLivraison).get();
    }

    @PostMapping(path = "/livraisons")
    public  Livraison save(@RequestBody Livraison livraison){
        return livraisonRepository.save(livraison);
    }


    @DeleteMapping(path = "/livraisons/{idLivraison}")
    public  void delete(@PathVariable Long idLivraison){
        livraisonRepository.deleteById(idLivraison);
    }
}
