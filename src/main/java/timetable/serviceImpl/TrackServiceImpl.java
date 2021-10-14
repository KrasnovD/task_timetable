package timetable.serviceImpl;

import org.springframework.stereotype.Service;
import timetable.DAO.TrackDAO;
import timetable.DAOImpl.TrackDAOImpl;
import timetable.classes.Route;
import timetable.classes.Track;
import timetable.entity.TrackEntity;
import timetable.service.TrackService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service("TrackService")
public class TrackServiceImpl implements TrackService {
    TrackDAO DAO;
    TrackDAOImpl trackDAO;
    public TrackServiceImpl(TrackDAOImpl trackDAOImpl) {
        this.trackDAO = trackDAOImpl;
    }

    @Override
    public Collection<TrackEntity> findAll(){
        try {
            return trackDAO.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public TrackEntity findById(Long id) {
        return null;
    }

    @Override
    public void save(TrackEntity entity) {

    }

    @Override
    public void delete(Long id) {

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

            for (long id: DAO.findAllId()
            ) {
                Route tempRoute = new Route();
                System.out.printf(trackDAO.firstStation(id));
                tempRoute.setFirstStation(trackDAO.firstStation(id));
                tempRoute.setLastStation(trackDAO.lastStation(id));
                tempRoute.setType(trackDAO.showType(id));
                tempRoute.setId(id);
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
