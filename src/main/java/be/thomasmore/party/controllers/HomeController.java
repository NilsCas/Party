package be.thomasmore.party.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final int mySpecialNumber = 729;

    @GetMapping("/")
    public String home() {
        return "home";
    }
    @GetMapping("/about")
    public String about(){
        return "about";
    }
}

