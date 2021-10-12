package timetable.serviceImpl;

import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;
import timetable.DAO.DaoException;
import timetable.DAOImpl.RouteDAOImpl;
import timetable.classes.Route;
import timetable.classes.Station;
import timetable.entity.RouteEntity;
import timetable.service.RouteService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service("RouteService")
public class RouteServiceImpl implements RouteService {

    private RouteDAOImpl routeDAO;

    public RouteServiceImpl(RouteDAOImpl routeDAOImpl) {
        this.routeDAO = routeDAOImpl;
    }

    @Override
    public List<RouteEntity> findAll() throws ServiceException {
        try {
            return routeDAO.readAll();
        } catch(DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public RouteEntity findById(Long id) throws ServiceException {
        try {
            return routeDAO.findById(id);
        } catch(DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void save(RouteEntity routeEntity) throws ServiceException {
        try {
            if(routeEntity.getId() != null) {
                routeDAO.update(routeEntity);
            } else {
                routeDAO.save(routeEntity);
            }
        } catch(DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void delete(Long id) throws ServiceException {
        try {
            routeDAO.delete(id);
        } catch(DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Station> showAllStations(long id) throws ServiceException {
        try {
            return routeDAO.showAllStations(id);
        } catch(DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }


}
