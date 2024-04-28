package service;

import domain.Sport;

import java.util.ArrayList;
import java.util.List;

public class SportServiceImpl implements SportService {
    private static final List<Sport> sports = new ArrayList<>();

    static {
        sports.add(new Sport(1, "Skateboarden"));
        sports.add(new Sport(2, "Surfen"));
        sports.add(new Sport(3, "Tennis"));
        sports.add(new Sport(4, "Voetbal"));
        sports.add(new Sport(5, "Boksen"));
    }

    @Override
    public List<Sport> getAllSports() {
        return sports;
    }
}
