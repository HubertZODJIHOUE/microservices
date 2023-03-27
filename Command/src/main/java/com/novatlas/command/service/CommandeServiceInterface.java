package com.novatlas.command.service;

import com.novatlas.command.dto.CommandDto;
import com.novatlas.command.exception.CommandNotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CommandeServiceInterface {
    ResponseEntity<List<CommandDto>> getAllCommands();

    ResponseEntity<CommandDto> getCommandById(Long idCommand) throws CommandNotFoundException;

    ResponseEntity<CommandDto> createCommand(CommandDto commandDto);

    ResponseEntity<CommandDto> updateCommand(Long idCommand, CommandDto commandDto) throws CommandNotFoundException;

    ResponseEntity<Void> deleteCommand(Long idCommand) throws CommandNotFoundException;

}
