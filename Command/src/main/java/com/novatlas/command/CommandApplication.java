package com.novatlas.command;

import com.novatlas.command.entities.Command;
import com.novatlas.command.repository.CommandRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CommandApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommandApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CommandRepository commandRepository){
        return  args -> {
            Command command = new Command(null, 12,"delta",773.0,null);
            Command command1 = new Command(null, 12,"fuckushima",33.0,null);
            Command command2 = new Command(null, 12,"portable",183.0,null);
            Command command3 = new Command(null, 12,"delpierro",823.0,null);
            Command command4 = new Command(null, 12,"ronaldo",423.0,null);
            Command command5 = new Command(null, 12,"brosure",12300.0,null);


            commandRepository.save(command3);
            commandRepository.save(command1);
            commandRepository.save(command2);
            commandRepository.save(command3);
            commandRepository.save(command4);
            commandRepository.save(command5);
            commandRepository.save(command);
        };
    }
}
