package com.novatlas.livraison;

import com.novatlas.livraison.entities.Command;
import com.novatlas.livraison.entities.Livraison;
import com.novatlas.livraison.repository.LivraisonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class LivraisonApplication {

    public static void main(String[] args) {
        SpringApplication.run(LivraisonApplication.class, args);
    }
    @Bean
    CommandLineRunner start(LivraisonRepository livraisonRepository){
      return args -> {
          Livraison livraison =new Livraison(null,new Date(2021, Calendar.FEBRUARY,02),new ArrayList<>(),"DANKO GATE");
          Livraison livraison1 = new Livraison(null,new Date(2021, Calendar.JANUARY,12),new ArrayList<>(),"HUBERT ZODJIHOUE");
          Livraison livraison2 = new Livraison(null,new Date(2022, Calendar.DECEMBER,07),new ArrayList<>(),"datta NOVA");
          Livraison livraison3 = new Livraison(null,new Date(2020, Calendar.MARCH,17),new ArrayList<>(),"JOJO TALEUR");
          Livraison livraison4 = new Livraison(null,new Date(2021, Calendar.APRIL,9),new ArrayList<>(),"MARIANNE COURSIERE");
          Livraison livraison5 = new Livraison(null,new Date(2022, Calendar.AUGUST,11),new ArrayList<>(),"TIKTOK DONOVAN");
          Livraison livraison6 = new Livraison(null,new Date(2023, Calendar.JANUARY,01),new ArrayList<>(),"MITCHEL CURRY");
//          Command command= new Command(null,1234,"delta force",1234,)
          livraisonRepository.save(livraison2);
          livraisonRepository.save(livraison1);
          livraisonRepository.save(livraison3);
          livraisonRepository.save(livraison4);
          livraisonRepository.save(livraison5);
          livraisonRepository.save(livraison6);
          livraisonRepository.save(livraison);



      };
    }
}
