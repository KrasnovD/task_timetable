package timetable.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import timetable.DAOImpl.RouteDAOImpl;
import timetable.DAOImpl.StationDAOImpl;
import timetable.service.RouteService;
import timetable.service.StationService;
import timetable.serviceImpl.RouteServiceImpl;
import timetable.serviceImpl.StationServiceImpl;

@Configuration
public class AppConfig {

        @Bean
        public StationService stationService() {
            return new StationServiceImpl(stationDAOImpl());
        }

        @Bean
        public StationDAOImpl stationDAOImpl() {
            return new StationDAOImpl();
        }

        @Bean
        public RouteService routeService() {
        return new RouteServiceImpl(routeDAOImpl());
    }

        @Bean
        public RouteDAOImpl routeDAOImpl() {
        return new RouteDAOImpl();
    }

}

