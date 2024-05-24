package com.example.paris20224;

import domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import repository.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

@Controller
@RequestMapping("/sports")
public class SportsController {
    @Autowired
    private SportRepository sportRepository;

    @Autowired
    private SportDisciplineRepository disciplineRepository;

    @Autowired
    private WedstrijdRepository wedstrijdRepository;

    @Autowired
    private UserRepositry userRepositry;

    @Autowired
    private TicketRepository ticketRepository;

    @GetMapping(value = "/overview")
    public String overviewSports(Model model, Principal principal) {
        MyUser user = userRepositry.findByUsername(principal.getName());
        model.addAttribute("sportsList", sportRepository.findAll());
        model.addAttribute("user", user);
        return "sports/overview";
    }

    @GetMapping(value = "/matches/{sportId}")
    public String viewSport(@PathVariable String sportId, Model model, Principal principal) {
        MyUser user = userRepositry.findByUsername(principal.getName());
        Sport sport = sportRepository.findByName(sportId);
        List<Wedstrijd> wedstrijden = wedstrijdRepository.findAllBySport(sport);
        Dictionary<Integer, Integer> ticketsAantal = new Hashtable<>();
        for (Wedstrijd wedstrijd : wedstrijden) {
            List<Tickets> tickets = ticketRepository.findTicketsByWedstrijdAndUser(wedstrijd, user);
            ticketsAantal.put(wedstrijd.getWedstrijdid(), tickets.size());
        }

        model.addAttribute("wedstrijden", wedstrijden);
        model.addAttribute("user", user);
        model.addAttribute("tickets", ticketsAantal);
        return "sports/matches-sport";
    }
}
