package com.example.paris20224;

import domain.Role;
import domain.Sport;
import domain.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import repository.SportRepository;
import repository.UserRepositry;

import java.util.Arrays;
import java.util.List;

@Component
public class InitDataConfig implements CommandLineRunner {
    private final PasswordEncoder encoder = new BCryptPasswordEncoder();
    @Autowired
    private SportRepository sportRepository;

    @Autowired
    private UserRepositry userRepositry;

    @Override
    public void run(String... args) {
        insertSports();
        insertUsers();
    }


    private void insertSports() {
        Sport skateboarden = new Sport("Skateboarden", "Skateboarden", "/images/skateboarden.jpg");
        Sport surfen = new Sport("Surfen", "Surfen", "/images/surfen.jpg");
        Sport tennis = new Sport("Tennis", "Tennis", "/images/tennis.jpg");
        Sport voetbal = new Sport("Voetbal", "Voetbal", "/images/voetbal.jpg");
        Sport boksen = new Sport("Boksen", "Boksen", "/images/boksen.jpg");
        List<Sport> sports = Arrays.asList(skateboarden, surfen, tennis,  voetbal, boksen);
        sportRepository.saveAll(sports);
    }

    private void insertUsers() {
        var user1 =
                MyUser.builder()
                        .username("AlexanderBal")
                        .role(Role.USER)
                        .password(encoder.encode("password"))
                        .fullname("Alexander Bal")
                        .build();
        var user2 =
                MyUser.builder()
                        .username("Jules1")
                        .role(Role.USER)
                        .password(encoder.encode("test123"))
                        .fullname("Jules Pieters")
                        .build();
        var user3 =
                MyUser.builder()
                        .username("Geertje")
                        .role(Role.USER)
                        .password(encoder.encode("user3"))
                        .fullname("Geert Bal")
                        .build();
        var admin1 =
                MyUser.builder()
                        .username("admin")
                        .role(Role.ADMIN)
                        .password(encoder.encode("admin1"))
                        .fullname("Admin First")
                        .build();
        var admin2 =
                MyUser.builder()
                        .username("admin2")
                        .role(Role.ADMIN)
                        .password(encoder.encode("adminos"))
                        .fullname("Admin Adminos")
                        .build();

        List<MyUser> users = Arrays.asList(user1, user2, user3, admin1, admin2);

        userRepositry.saveAll(users);
    }
}
