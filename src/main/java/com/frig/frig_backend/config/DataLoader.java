package com.frig.frig_backend.config;

import com.frig.frig_backend.model.UserModel;
import com.frig.frig_backend.repository.FrigJpaRespository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    public CommandLineRunner loadData(FrigJpaRespository repository) {
        return args -> {
            repository.save(new UserModel("jester", "1234"));

            // Retrieve and interact
            System.out.println("Fetching all users:");
            repository.findAll().forEach(user ->
                    System.out.println(" - " + user.getUsername())
            );
        };
    }
}
