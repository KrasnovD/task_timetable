package timetable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import timetable.DAO.DaoException;
import timetable.DAOImpl.StationDAOImpl;

import java.sql.DriverManager;
import java.sql.SQLException;
//import timetable.repository.RouteRepository;
//import timetable.repository.TrackRepository;
//import timetable.service.RouteService;

@Controller
public class TestController {
//    @Autowired
//    private RouteRepository routeRepository;
//
//    @Autowired
//    private RouteService routeService;
//    @Autowired
//    private TrackRepository trackRepository;

    @GetMapping("/")
    public String test(Model model) throws DaoException, SQLException {
        StationDAOImpl temp = null;
        temp.setConnection(DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root"));
        System.out.println(temp.findById(1L));
        model.addAttribute("station", temp.findById(1L).getName());
        return "station";
    }
//        model.addAttribute("all",routeRepository.showAllRoute());
//        model.addAttribute("first", routeRepository.showFirstStation());
//        model.addAttribute("last", routeRepository.showLastStation());
//        model.addAttribute("type",routeService.typeRoute());
//        model.addAttribute("all",routeService.showAllRoutes());
//        return "index";
//    }
//
//    @GetMapping("/{id}")
//    public String ttest(Model model, @PathVariable Long id){
//        model.addAttribute("all", routeRepository.showAllRoute(id));
//        return "routeStations";
//    }
//
//    @GetMapping("/routes/{name}")
//    public String mainPage(@PathVariable String name, Model model){
//        model.addAttribute("all",routeService.showAllRoutesByStation(name));
//        return "index";
//    }
}
