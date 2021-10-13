package timetable.serviceImpl;

import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;
import timetable.DAOImpl.RouteDAOImpl;
import timetable.classes.Station;
import timetable.entity.RouteEntity;
import timetable.service.RouteService;

import java.util.ArrayList;
import java.util.List;

@Service("RouteService")
public class RouteServiceImpl implements RouteService {

    private RouteDAOImpl routeDAO;

    public RouteServiceImpl(RouteDAOImpl routeDAOImpl) {
        this.routeDAO = routeDAOImpl;
    }

    @Override
    public List<RouteEntity> findAll(){
        try {
            return routeDAO.readAll();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public RouteEntity findById(Long id){
        try {
            return routeDAO.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new RouteEntity();
        }
    }

    @Override
    public void save(RouteEntity routeEntity){
        try {
            if(routeEntity.getId() != null) {
                routeDAO.update(routeEntity);
            } else {
                routeDAO.save(routeEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id){
        try {
            routeDAO.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
