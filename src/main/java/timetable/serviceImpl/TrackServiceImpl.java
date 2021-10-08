package timetable.serviceImpl;

import org.springframework.stereotype.Service;
import timetable.DAO.DaoException;
import timetable.DAOImpl.TrackDAOImpl;
import timetable.classes.Route;
import timetable.entity.RouteEntity;
import timetable.entity.TrackEntity;
import timetable.service.ServiceException;
import timetable.service.TrackService;

import javax.sound.midi.Track;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Service("TrackService")
public class TrackServiceImpl implements TrackService {

    TrackDAOImpl trackDAO;
    public TrackServiceImpl(TrackDAOImpl trackDAOImpl) {
        this.trackDAO = trackDAOImpl;
    }

    @Override
    public List<TrackEntity> findAll() throws ServiceException {
        try {
            return trackDAO.readAll();
        } catch(DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public TrackEntity findById(Long id) throws ServiceException {
        try {
            return trackDAO.findById(id);
        } catch(DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void save(TrackEntity entity) throws ServiceException {
        try {
            if(entity.getId() != null) {
                trackDAO.update(entity);
            } else {
                trackDAO.save(entity);
            }
        } catch(DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void delete(Long id) throws ServiceException {
        try {
            trackDAO.delete(id);
        } catch(DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }
    @Override
    public List<Route> showAllroutes() throws timetable.service.ServiceException {
        try {
            List<Route> routeList = new ArrayList<>();
            System.out.println(123);
            List<TrackEntity> trackEntities = findAll();
            System.out.println(123);
            for (TrackEntity track: trackEntities
            ) {
                Route tempRoute = new Route();
                System.out.println(track.getId());
                tempRoute.setFirstStation(trackDAO.firstStation(track.getId()));
                System.out.println(123);
                System.out.println(tempRoute.getFirstStation());
                tempRoute.setLastStation(trackDAO.lastStation(track.getId()));
                System.out.println(123);
                tempRoute.setType(trackDAO.showType(track.getId()));
                System.out.println(123);
                routeList.add(tempRoute);
            }
        } catch (DaoException | SQLException e) {
            throw new org.hibernate.service.spi.ServiceException(e.getMessage());
        }
        return new ArrayList<>();
    }
}
