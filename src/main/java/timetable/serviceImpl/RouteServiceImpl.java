package timetable.serviceImpl;

import org.hibernate.service.spi.ServiceException;
import timetable.DAO.DaoException;
import timetable.DAOImpl.RouteDAOImpl;
import timetable.entity.RouteEntity;
import timetable.service.RouteService;

import java.util.List;

public class RouteServiceImpl implements RouteService {

    private RouteDAOImpl routeDAO;

    public RouteServiceImpl(RouteDAOImpl routeDAOImpl) {
    }

    @Override
    public List<RouteEntity> findAll() throws org.hibernate.service.spi.ServiceException {
        try {
            return routeDAO.readAll();
        } catch(DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public RouteEntity findById(Long id) throws org.hibernate.service.spi.ServiceException {
        try {
            return routeDAO.findById(id);
        } catch(DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void save(RouteEntity routeEntity) throws org.hibernate.service.spi.ServiceException {
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
    public void delete(Long id) throws org.hibernate.service.spi.ServiceException {
        try {
            routeDAO.delete(id);
        } catch(DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
