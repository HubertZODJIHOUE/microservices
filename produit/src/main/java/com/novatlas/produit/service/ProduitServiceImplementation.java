package com.novatlas.produit.service;
import com.novatlas.produit.dto.ProduitDTO;
import com.novatlas.produit.entities.Produit;
import com.novatlas.produit.exceptions.ProduitNotFoundException;
import com.novatlas.produit.repository.ProduitRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class ProduitServiceImplementation implements ProduitServiceInterface {

    private ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private ProduitRepository produitRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(ProduitServiceImplementation.class);



    public ProduitDTO converToDTO(Produit produit){
        return modelMapper.map(produit , ProduitDTO.class);
    }
    public Produit  convertToEntity(ProduitDTO produitDTO){
        return modelMapper.map(produitDTO, Produit.class );
    }

    @Override
    public ResponseEntity<List<ProduitDTO>> getAllProducts() {
        LOGGER.info("Récupérations des produit dans la BD");
        List<Produit> products= produitRepository.findAll();
        List<ProduitDTO> produitDTOList =products.stream()
                .map(produit -> converToDTO(produit)).collect(Collectors.toList());
        return new ResponseEntity<>(produitDTOList , HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProduitDTO> getProductById(Long idProduit) throws ProduitNotFoundException {
        LOGGER.info("Recherche du produit {}", idProduit);
        Optional<Produit> optionalProduit = produitRepository.findById(idProduit);
        if (optionalProduit.isPresent()) {
            Produit produit = optionalProduit.get();
            ProduitDTO produitDTO = converToDTO(produit);
            return new ResponseEntity<>(produitDTO, HttpStatus.OK);
        } else {
            LOGGER.warn("Aucun produit avec l'id : {}", idProduit);
            throw new ProduitNotFoundException("Aucun produit avec l'id  " + idProduit);
        }
    }

    @Override
    public ResponseEntity<ProduitDTO> createProduct(ProduitDTO produitDTO) {
        LOGGER.info("Creaton d'un produit: {}", produitDTO);
        Produit produit = convertToEntity(produitDTO);
        Produit saveProduit = produitRepository.save(produit);
        ProduitDTO saveProduitDto = converToDTO(saveProduit);
        return new ResponseEntity<>(saveProduitDto, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ProduitDTO> updateProduct(Long idProduct, ProduitDTO produitDTO) throws ProduitNotFoundException {
        LOGGER.info("Mise à jour du Produit  {}", idProduct);
        Optional<Produit> optionalProduit = produitRepository.findById(idProduct);
        if (optionalProduit.isPresent()) {
            Produit existingProduct = optionalProduit.get();
            existingProduct.setPrixProduit(produitDTO.getPrixProduit());
            existingProduct.setNomProduit(produitDTO.getNomProduit());
            existingProduct.setIdProduit(produitDTO.getIdProduit());
            Produit savedProduit = produitRepository.save(existingProduct);
            ProduitDTO saveProduitDto = converToDTO(savedProduit);
            return new ResponseEntity<>(saveProduitDto, HttpStatus.OK);
        } else {
            LOGGER.warn("Aucun produit avec id: {}", idProduct);
            throw new ProduitNotFoundException("Aucun produit avec id: " + idProduct);
        }
    }

    @Override
    public ResponseEntity<Void> deleteProduct(Long idProduct) throws ProduitNotFoundException {
        LOGGER.info("Suppression produit numéros {}", idProduct);
        Optional<Produit> optionalProduit = produitRepository.findById(idProduct);
        if (optionalProduit.isPresent()) {
            Produit exisingProduit = optionalProduit.get();
            produitRepository.deleteById(exisingProduit.getIdProduit());
            LOGGER.info("supressions du produit  avec id {}", idProduct);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            LOGGER.warn("Aucun produit avec  l'id: {}", idProduct);
            throw new ProduitNotFoundException("Aucun produit avec  l'id: " + idProduct);
        }
    }
}
