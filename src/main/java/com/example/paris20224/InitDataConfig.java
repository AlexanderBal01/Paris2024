package com.example.paris20224;

import domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import repository.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

@Component
public class InitDataConfig implements CommandLineRunner {
    private final PasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    private SportRepository sportRepository;

    @Autowired
    private UserRepositry userRepositry;

    @Autowired
    private SportDisciplineRepository sportDisciplineRepository;

    @Autowired
    private StadiumRepository stadiumRepository;

    @Autowired
    private WedstrijdRepository wedstrijdRepository;

    @Override
    public void run(String... args) {
        insertSports();
        insertUsers();
        insertDisciplines();
        insertStadia();
        insertWedstrijden();
    }


    private void insertSports() {
        Sport skateboarden =
                Sport.builder()
                        .name("Skateboarden")
                        .imageDescription("Skateboarden")
                        .imageLocation("/images/skateboarden.jpg")
                        .build();
        Sport zwemmen =
                Sport.builder()
                        .name("Zwemmen")
                        .imageDescription("Zwemmen")
                        .imageLocation("/images/zwemmen.jpg")
                        .build();
        Sport tennis =
                Sport.builder()
                        .name("Tennis")
                        .imageDescription("Tennis")
                        .imageLocation("/images/tennis.jpg")
                        .build();
        Sport voetbal =
                Sport.builder()
                        .name("Voetbal")
                        .imageDescription("Voetbal")
                        .imageLocation("/images/voetbal.jpg")
                        .build();
        Sport boksen =
                Sport.builder()
                        .name("Boksen")
                        .imageDescription("Boksen")
                        .imageLocation("/images/boksen.jpg")
                        .build();

        List<Sport> sports = Arrays.asList(skateboarden, zwemmen, tennis,  voetbal, boksen);
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

    private void insertDisciplines() {
        var skateboarden = sportRepository.findByName("Skateboarden");
        var zwemmen = sportRepository.findByName("zwemmen");
        var tennis = sportRepository.findByName("Tennis");
        var voetbal = sportRepository.findByName("Voetbal");
        var boksen = sportRepository.findByName("Boksen");

        SportDiscipline discipline1 =
                SportDiscipline.builder()
                        .sport(skateboarden)
                        .name("park mannen")
                        .build();
        SportDiscipline discipline2 =
                SportDiscipline.builder()
                        .sport(skateboarden)
                        .name("street mannen")
                        .build();

        SportDiscipline discipline3 =
                SportDiscipline.builder()
                        .sport(zwemmen)
                        .name("100m vrije slag")
                        .build();
        SportDiscipline discipline4 =
                SportDiscipline.builder()
                        .sport(zwemmen)
                        .name("100m vlinderslag")
                        .build();

        SportDiscipline discipline5 =
                SportDiscipline.builder()
                        .sport(tennis)
                        .name("mannen duos")
                        .build();
        SportDiscipline discipline6 =
                SportDiscipline.builder()
                        .sport(tennis)
                        .name("vrouwen duos")
                        .build();

        SportDiscipline discipline7 =
                SportDiscipline.builder()
                        .sport(voetbal)
                        .name("mannen")
                        .build();
        SportDiscipline discipline8 =
                SportDiscipline.builder()
                        .sport(voetbal)
                        .name("vrouwen")
                        .build();

        SportDiscipline discipline9 =
                SportDiscipline.builder()
                        .sport(boksen)
                        .name("lichtgewicht")
                        .build();
        SportDiscipline discipline10 =
                SportDiscipline.builder()
                        .sport(boksen)
                        .name("zwaar gewicht")
                        .build();

        List<SportDiscipline> disciplines = Arrays.asList(discipline1, discipline2, discipline3, discipline4, discipline5, discipline6, discipline7, discipline8, discipline9, discipline10);
        sportDisciplineRepository.saveAll(disciplines);
    }

    private  void insertStadia() {
        Stadium stadium1 =
                Stadium.builder()
                        .name("Stade de France")
                        .build();
        Stadium stadium2 =
                Stadium.builder()
                        .name("Olympic Aquatics Centre #1")
                        .build();
        Stadium stadium3 =
                Stadium.builder()
                        .name("Olympic Aquatics Centre #2")
                        .build();
        Stadium stadium4 =
                Stadium.builder()
                        .name("Le Bourget Pavilion")
                        .build();
        Stadium stadium5 =
                Stadium.builder()
                        .name("Le Bourget Shooting Range")
                        .build();
        Stadium stadium6 =
                Stadium.builder()
                        .name("Champ de Mars")
                        .build();

        List<Stadium> stadia = Arrays.asList(stadium1, stadium2, stadium3, stadium4, stadium5, stadium6);
        stadiumRepository.saveAll(stadia);
    }

    private void insertWedstrijden() {
        Sport skateboarden = sportRepository.findByName("Skateboarden");
        SportDiscipline parkMannen = sportDisciplineRepository.findByName("Park mannen");
        SportDiscipline streetMannen = sportDisciplineRepository.findByName("Street mannen");

        Stadium leBourgetPavilion = stadiumRepository.findByName("Le Bourget Pavilion");
        Stadium champDeMars = stadiumRepository.findByName("Champ de Mars");

        Wedstrijd wedstrijd1 =
                Wedstrijd.builder()
                        .datum(LocalDate.of(2024, 7, 27))
                        .aantalPlaatsen(100)
                        .aantalBezettePlaatsen(0)
                        .discipline(parkMannen)
                        .sport(skateboarden)
                        .startUur(LocalTime.of(13, 0, 0, 0))
                        .stadium(leBourgetPavilion)
                        .prijs(99.99)
                        .build();
        Wedstrijd wedstrijd2 =
                Wedstrijd.builder()
                        .datum(LocalDate.of(2024, 7, 27))
                        .aantalPlaatsen(100)
                        .aantalBezettePlaatsen(0)
                        .discipline(streetMannen)
                        .sport(skateboarden)
                        .startUur(LocalTime.of(15, 30, 0, 0))
                        .stadium(champDeMars)
                        .prijs(124.99)
                        .build();

        List<Wedstrijd> wedstrijden = Arrays.asList(wedstrijd1, wedstrijd2);
        wedstrijdRepository.saveAll(wedstrijden);
    }
}
