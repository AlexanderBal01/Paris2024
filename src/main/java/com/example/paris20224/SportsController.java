package com.example.paris20224;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import repository.SportRepository;

@Controller
@RequestMapping("/sports")
public class SportsController {
    @Autowired
    private SportRepository repository;

    @GetMapping(value = "/overview")
    public String overviewSports(Model model) {
        model.addAttribute("sportsList", repository.findAll());
        return "sports/overview";
    }

    @GetMapping(value = "/{sportId}")
    public String viewSport(@PathVariable String sportId, Model model) {
        model.addAttribute("sport", repository.findByName(sportId));
        return "sports/sport";
    }
}
