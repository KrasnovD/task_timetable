package timetable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import timetable.repository.RouteRepository;
import timetable.repository.TrackRepository;
import timetable.service.RouteService;

@Controller
public class TestController {
    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private RouteService routeService;
    @Autowired
    private TrackRepository trackRepository;

    @GetMapping("/")
    public String test(Model model){
//        model.addAttribute("all",routeRepository.showAllRoute());
//        model.addAttribute("first", routeRepository.showFirstStation());
//        model.addAttribute("last", routeRepository.showLastStation());
//        model.addAttribute("type",routeService.typeRoute());
        model.addAttribute("all",routeService.showAllRoutes());
        return "index";
    }

    @GetMapping("/{id}")
    public String ttest(Model model, @PathVariable Long id){
        model.addAttribute("all", routeRepository.showAllRoute(id));
        return "routeStations";
    }
}
