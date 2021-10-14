package timetable.serviceImpl;

import liquibase.pro.packaged.A;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import timetable.DAO.RouteDAO;
import timetable.DAOImpl.RouteDAOImpl;
import timetable.classes.Station;
import timetable.entity.RouteEntity;
import timetable.service.RouteService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service("RouteService")
public class RouteServiceImpl implements RouteService {

    private RouteDAOImpl routeDAO;

    public RouteServiceImpl(RouteDAOImpl routeDAOImpl) {
        this.routeDAO = routeDAOImpl;
    }

    @Override
    public Collection<RouteEntity> findAll(){
        try {
            return routeDAO.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public RouteEntity findById(Long id){
        return null;
    }

    @Override
    public void save(RouteEntity routeEntity){
    }

    @Override
    public void delete(Long id){

    }

    @Override
    public List<Station> showAllStations(long id) throws ServiceException {
        try {
            return routeDAO.showAllStations(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }


}
