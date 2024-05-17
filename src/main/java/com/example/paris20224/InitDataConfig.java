package com.example.paris20224;

import domain.Sport;
import domain.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import repository.SportRepository;
import repository.UserRepositry;

@Component
public class InitDataConfig implements CommandLineRunner {
    @Autowired
    private SportRepository sportRepository;

    @Autowired
    private UserRepositry userRepositry;

    @Override
    public void run(String... args) {
        insertSports();
    }

    private void insertSports() {
        sportRepository.save(new Sport("Skateboarden", "Skateboarden", "/images/skateboarden.jpg"));
        sportRepository.save(new Sport("Surfen", "Surfen", "/images/surfen.jpg"));
        sportRepository.save(new Sport("Tennis", "Tennis", "/images/tennis.jpg"));
        sportRepository.save(new Sport("Voetbal", "Voetbal", "/images/voetbal.jpg"));
        sportRepository.save(new Sport("Boksen", "Boksen", "/images/boksen.jpg"));
    }

    private void insertUsers() {
    }
}
