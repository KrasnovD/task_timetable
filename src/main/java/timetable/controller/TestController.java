package timetable.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import timetable.DAO.StationDAO;
import timetable.DAOImpl.StationDAOImpl;
import timetable.entity.StationEntity;
import timetable.service.StationServiceImpl;
import java.util.List;

@Controller
public class TestController {
    private StationServiceImpl stationService;
    private StationDAOImpl stationDAO;
    @GetMapping("/")
    public String test(Model model){
        try {
//            List<StationEntity> stationEntityList = stationService.findAll();
//            System.out.println(stationEntityList.get(0).getName());
            model.addAttribute("all", stationDAO.findById(1L));
        }catch (Exception exc){
            System.out.println(exc.toString());
        }
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
