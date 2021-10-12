package timetable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import timetable.serviceImpl.RouteServiceImpl;
import timetable.serviceImpl.StationServiceImpl;
import timetable.serviceImpl.TrackServiceImpl;

import java.sql.Date;
import java.time.LocalDate;

@Controller
public class TestController {
    @Autowired
    private RouteServiceImpl routeService;
    @Autowired
    private TrackServiceImpl trackService;

    @GetMapping("/")
    public String showRouteByStationGet(Model model){
        return "index";
    }

    @PostMapping("/")
    public String showRouteByStationPost(Model model, @RequestParam String name){
        try {
            model.addAttribute("stations", trackService.showRouteByStation(name));
        }catch (Exception exc){
            System.out.println(exc.toString());
        }
        return "route";
    }


    @GetMapping("/allroutes")
    public String showAllroutes(Model model){
        try {
            model.addAttribute("stations", trackService.showAllroutes());
        }catch (Exception exc){
            System.out.println(exc.toString());
        }
        return "routes";
    }


    @GetMapping("/{id}")
    public String showAllStations(Model model, @PathVariable Long id){
        model.addAttribute("stations", routeService.showAllStations(id));
        return "routeStations";
    }

    @GetMapping("/buy/{id}")
    public String buyTicketGet(Model model, @PathVariable Long id){
        model.addAttribute("id",id);
        model.addAttribute("date", LocalDate.now());
        return "buyticket";
    }

    @PostMapping("/buy/{id}")
    public String buyTicketPost(Model model, @RequestParam String name, @RequestParam String surname, @RequestParam String tel, @RequestParam Date date){
        return "buyticket";
    }
}
