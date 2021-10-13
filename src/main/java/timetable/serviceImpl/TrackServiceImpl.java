package timetable.serviceImpl;

import org.springframework.stereotype.Service;
import timetable.DAOImpl.TrackDAOImpl;
import timetable.classes.Route;
import timetable.entity.TrackEntity;
import timetable.service.TrackService;
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
    public List<TrackEntity> findAll(){
        try {
            return trackDAO.readAll();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public TrackEntity findById(Long id){
        try {
            return trackDAO.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new TrackEntity();
        }
    }

    @Override
    public void save(TrackEntity entity){
        try {
            if(entity.getId() != null) {
                trackDAO.update(entity);
            } else {
                trackDAO.save(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try {
            trackDAO.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String showFirstStation(long id) throws SQLException {
        TrackEntity trackEntity = findById(id);
        return trackDAO.firstStation(trackEntity.getId());
    }

    @Override
    public String showLastStation(long id) throws SQLException {
        TrackEntity trackEntity = findById(id);
        return trackDAO.lastStation(trackEntity.getId());
    }

    @Override
    public String showType(long id){
        TrackEntity trackEntity = findById(id);
        return trackDAO.showType(trackEntity.getId());
    }

    @Override
    public List<Route> showAllroutes(){
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
                routeList.add(tempRoute);
            }
            return routeList;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public List<Route> showRouteByStation(String stationName){
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
                routeList.add(tempRoute);
            }
            return routeList;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
