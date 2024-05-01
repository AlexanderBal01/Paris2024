package com.example.paris20224;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.SportService;

@Controller
@RequestMapping("/sports")
public class SportsController {
    @Autowired
    private SportService sportService;

    @GetMapping(value = "/overview")
    public String overviewSports(Model model) {
        model.addAttribute("sportsList", sportService.getAllSports());
        return "sports/overview";
    }
}
