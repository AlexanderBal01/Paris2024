package service;

import domain.Sport;

import java.util.ArrayList;
import java.util.List;

public class SportServiceImpl implements SportService {
    private static final List<Sport> sports = new ArrayList<>();

    static {
        sports.add(new Sport(1, "Skateboarden", "Skateboarden", "/images/skateboarden.jpg"));
        sports.add(new Sport(2, "Surfen", "Surfen", "/images/surfen.jpg"));
        sports.add(new Sport(3, "Tennis", "Tennis", "/images/tennis.jpg"));
        sports.add(new Sport(4, "Voetbal", "Voetbal", "/images/voetbal.jpg"));
        sports.add(new Sport(5, "Boksen", "Boksen", "/images/boksen.jpg"));
    }

    @Override
    public List<Sport> getAllSports() {
        return sports;
    }
}
