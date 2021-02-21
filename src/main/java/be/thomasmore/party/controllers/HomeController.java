package be.thomasmore.party.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

@Controller
public class HomeController {

    private final int mySpecialNumber = 729;
    private final String appName = "It's Partytime!";
    private final LocalDateTime time = LocalDateTime.now();
    private final LocalDateTime deadline = time.plusDays(30);
    private String correctTime = time.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    private String correctDeadline = deadline.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

    @GetMapping({"/", "/home"})
    public String home(Model model) {
        model.addAttribute("mySpecialNumber", mySpecialNumber);
        model.addAttribute("appName", appName);
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("mySpecialNumber", mySpecialNumber);
        return "about";
        //about.html zal gegenereerd worden
    }

    @GetMapping("/pay")
    public String pay(Model model) {
        model.addAttribute("tijd", correctTime);
        model.addAttribute("deadline", correctDeadline);
        return "pay";
    }

    @GetMapping("/venuedetails/{venueName}")
    public String venueDetails(Model model, @PathVariable(required = false) String venueName) {
        model.addAttribute("venueName", (venueName!=null) ? venueName : "No venue chosen!");
        return "venuedetails";
    }

    /*@GetMapping({"/venuedetails/{venueIndex}", "/venuedetails"})
    public String venueDetails(Model model, @PathVariable(required = false) Double venueIndex){
        if (venueIndex != null && venueNames.length > Math.floor(venueIndex) && Math.floor(venueIndex) >= 0) {
            String venue = venueNames[(int)Math.floor(venueIndex)];
            model.addAttribute("venueName", venue);
        } else {
            model.addAttribute("venueName", "Choose a number between 0 and " + (venueNames.length-1));
        }
        model.addAttribute("venueIndexMax", venueNames.length-1);
        return "venuedetails";
    }*/

    @GetMapping("/venuelist")
    public String venueList(Model model) {
        return "venuelist";
    }

    /*@GetMapping("/venuedetailsbyindex/{index}")
    public String venueDetailsByIndex(Model model, @PathVariable int index){
        model.addAttribute("venueName", index >= 0 && index < venueNames.length ? venueNames : null);
        return "venuedetails";
    }*/
}

