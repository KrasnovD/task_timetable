package timetable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import timetable.service.RouteService;

@Controller
public class RouteController {
    @Autowired
    private RouteService routeService;

    @GetMapping("/{id}")
    public String showAllStations(Model model, @PathVariable Long id){
        model.addAttribute("stations", routeService.showAllStations(id));
        return "routeStations";
    }
}
