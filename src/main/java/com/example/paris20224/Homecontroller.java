package com.example.paris20224;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Homecontroller {

    @GetMapping("/")
    public String showHomePage() {
        return "redirect:/sports/overview";
    }
}
