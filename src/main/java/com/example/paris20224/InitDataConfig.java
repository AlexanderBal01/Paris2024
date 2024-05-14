package com.example.paris20224;

import domain.Sport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import repository.SportRepository;

@Component
public class InitDataConfig implements CommandLineRunner {
    @Autowired
    private SportRepository repository;

    @Override
    public void run(String... args) {

        repository.save(new Sport("Skateboarden", "Skateboarden", "/images/skateboarden.jpg"));
        repository.save(new Sport("Surfen", "Surfen", "/images/surfen.jpg"));
        repository.save(new Sport("Tennis", "Tennis", "/images/tennis.jpg"));
        repository.save(new Sport("Voetbal", "Voetbal", "/images/voetbal.jpg"));
        repository.save(new Sport("Boksen", "Boksen", "/images/boksen.jpg"));
    }
}
