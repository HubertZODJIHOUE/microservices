package com.novatlas.command.controller;

import com.novatlas.command.entities.Command;
import com.novatlas.command.repository.CommandRepository;
import com.novatlas.command.service.CommandeServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commands")
public class CommandController {
    @Autowired
    private CommandRepository commandRepository;
    @Autowired
    private CommandeServiceImplementation commandeServiceImplementation;

//    @GetMapping()
//    public ResponseEntity<List<Command>> getAllCommands(){
//        return  commandeServiceImplementation.getAllCommands();
//    }

    @GetMapping(path = "/{idCommand}")
    public  Command getCommand(@PathVariable(name = "idCommand") Long idCommand){
        return commandRepository.findById(idCommand).get();
    }

    @PostMapping()
    public  Command createCommand(@RequestBody Command command){
        return commandRepository.save(command);
    }


    @DeleteMapping(path = "/{idCommand}")
    public  void delete(@PathVariable Long idCommand){
        commandRepository.deleteById(idCommand);
    }
}
