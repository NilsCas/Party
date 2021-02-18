package be.thomasmore.party.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

@Controller
public class HomeController {

    private final int mySpecialNumber = 729;
    private final String appName = "It's Partytime!";
    private final LocalDateTime time = LocalDateTime.now();
    private final LocalDateTime deadline = time.plusDays(30);


    @GetMapping({"/", "/home"})
    public String home(Model model) {
        model.addAttribute("mySpecialNumber",mySpecialNumber);
        model.addAttribute("appName",appName);
        return "home";
    }
    @GetMapping("/about")
    public String about(Model model){
        model.addAttribute("mySpecialNumber",mySpecialNumber);
        return "about";
    }
    @GetMapping("/pay")
    public String pay(Model model){
        time.format(DateTimeFormatter.ofPattern("PatternRegex"));
        model.addAttribute("tijd",time);
        return "pay";
    }
}

