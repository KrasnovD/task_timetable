package timetable.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import timetable.DAOImpl.RouteDAOImpl;
import timetable.DAOImpl.StationDAOImpl;
import timetable.DAOImpl.TrackDAOImpl;
import timetable.service.RouteService;
import timetable.service.StationService;
import timetable.service.TrackService;
import timetable.serviceImpl.RouteServiceImpl;
import timetable.serviceImpl.StationServiceImpl;
import timetable.serviceImpl.TrackServiceImpl;

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

        public TrackService trackService(){ return  new TrackServiceImpl(trackDAOImpl());}

        public TrackDAOImpl trackDAOImpl(){return new TrackDAOImpl();}

}

