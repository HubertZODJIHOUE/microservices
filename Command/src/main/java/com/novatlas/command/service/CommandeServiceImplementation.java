package com.novatlas.command.service;

import com.novatlas.command.dto.CommandDto;
import com.novatlas.command.entities.Command;
import com.novatlas.command.exception.CommandNotFoundException;
import com.novatlas.command.repository.CommandRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommandeServiceImplementation  implements  CommandeServiceInterface{
    @Autowired
    private CommandRepository commandRepository;
//    ne trouve pas le model mapper donc pas de convertToDto et convertoEntity
   private ModelMapper modelMapper = new ModelMapper();
   public CommandDto converToDTO(Command produit){
        return modelMapper.map(produit , CommandDto.class);
    }
    public Command  convertToEntity(CommandDto produitDTO){
        return modelMapper.map(produitDTO, Command.class );
    }


    private static final Logger LOGGER = LoggerFactory.getLogger(CommandeServiceImplementation.class);


    @Override
    public ResponseEntity<List<CommandDto>> getAllCommands() {
        LOGGER.info("Recuperation de toutes les commandes");
        List<Command> commandList = commandRepository.findAll();
        List<CommandDto> commandDtoList = commandList.stream()
                .map(command -> converToDTO(command))
                .collect(Collectors.toList());
        return new ResponseEntity<>(commandDtoList, HttpStatus.OK);


    }

    @Override
    public ResponseEntity<CommandDto> getCommandById(Long idCommand) throws CommandNotFoundException {
        LOGGER.info("Recherche de la commande numeros: {}", idCommand);
        Optional<Command> optionalCommand = commandRepository.findById(idCommand);
        if (optionalCommand.isPresent()) {
            Command command = optionalCommand.get();
            CommandDto commandDto = converToDTO(command);
            return new ResponseEntity<>(commandDto, HttpStatus.OK);
        } else {
            LOGGER.warn("Aucune commande avec l'id : {}", idCommand);
            throw new CommandNotFoundException("Aucun produit avec l'id  " + idCommand);
        }
    }

    @Override
    public ResponseEntity<CommandDto> createCommand(CommandDto commandDto) {
        LOGGER.info("Creaton d'un produit: {}", commandDto);
        Command command = convertToEntity(commandDto);
        Command saveCommande = commandRepository.save(command);
        CommandDto commandDtotoSave = converToDTO(saveCommande);
        return new ResponseEntity<>(commandDtotoSave, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<CommandDto> updateCommand(Long idCommand, CommandDto commandDto) throws CommandNotFoundException {
        LOGGER.info("Mise à jour de la commande numeros  {}", idCommand);
        Optional<Command> optionalCommand = commandRepository.findById(idCommand);
        if (optionalCommand.isPresent()) {
            Command existingCommand = optionalCommand.get();
            existingCommand.setNomCommand(commandDto.getNomCommand());
            existingCommand.setNumerosCommand(commandDto.getNumerosCommand());
            existingCommand.setPrixTotal(commandDto.getPrixTotal());
            // partir a revoir avec commande_produit
            Command savedCommand = commandRepository.save(existingCommand);
            CommandDto saveCommandDto = converToDTO(savedCommand);
            return new ResponseEntity<>(saveCommandDto, HttpStatus.OK);
        } else {
            LOGGER.warn("Aucune  commande avec l'id: {}", idCommand);
            throw new CommandNotFoundException("Aucune command avec id: " + idCommand);
        }
    }

    @Override
    public ResponseEntity<Void> deleteCommand(Long idCommand) throws CommandNotFoundException {
        LOGGER.info("Suppression de la command numéros {}", idCommand);
        Optional<Command> commandOptional = commandRepository.findById(idCommand);
        if (commandOptional.isPresent()) {
            Command existingCommand = commandOptional.get();
            commandRepository.deleteById(existingCommand.getId());
            LOGGER.info("supressions de la commande numéros  {}", idCommand);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            LOGGER.warn("Aucune commande avec  l'id: {}", idCommand);
            throw new CommandNotFoundException("Aucune commande avec  l'id: " + idCommand);
        }
    }




}





