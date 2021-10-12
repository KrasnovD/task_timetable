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
    public String showFirstStation(long id) throws ServiceException, SQLException, DaoException {
        TrackEntity trackEntity = findById(id);
        return trackDAO.firstStation(trackEntity.getId());
    }

    @Override
    public String showLastStation(long id) throws ServiceException, SQLException, DaoException {
        TrackEntity trackEntity = findById(id);
        return trackDAO.lastStation(trackEntity.getId());
    }

    @Override
    public String showType(long id) throws ServiceException, DaoException {
        TrackEntity trackEntity = findById(id);
        return trackDAO.showType(trackEntity.getId());
    }

    @Override
    public List<Route> showAllroutes() throws timetable.service.ServiceException {
        try {
            List<Route> routeList = new ArrayList<>();
            List<TrackEntity> trackEntities = trackDAO.readAll();
            for (TrackEntity track: trackEntities
            ) {
                Route tempRoute = new Route();
                tempRoute.setFirstStation(trackDAO.firstStation(track.getId()));
                tempRoute.setLastStation(trackDAO.lastStation(track.getId()));
                tempRoute.setType(trackDAO.showType(track.getId()));
                tempRoute.setId(track.getId());
//                System.out.println(tempRoute.getFirstStation()+" "+tempRoute.getLastStation()+ " "+tempRoute.getType());
                routeList.add(tempRoute);
            }
            return routeList;
        } catch (DaoException | SQLException e) {
            throw new org.hibernate.service.spi.ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Route> showRouteByStation(String stationName) throws ServiceException {
        try {
            List<Route> routeList = new ArrayList<>();
            List<TrackEntity> trackEntities = trackDAO.TrackByStation(stationName);
            System.out.println(stationName);
            for (TrackEntity track: trackEntities
            ) {
                Route tempRoute = new Route();
                tempRoute.setFirstStation(trackDAO.firstStation(track.getId()));
                tempRoute.setLastStation(trackDAO.lastStation(track.getId()));
                tempRoute.setType(trackDAO.showType(track.getId()));
                tempRoute.setId(track.getId());
//                System.out.println(tempRoute.getFirstStation()+" "+tempRoute.getLastStation()+ " "+tempRoute.getType());
                routeList.add(tempRoute);
            }
            return routeList;
        } catch (DaoException | SQLException e) {
            throw new org.hibernate.service.spi.ServiceException(e.getMessage());
        }
    }
}
