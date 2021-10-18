package timetable.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import timetable.DAO.TrackDAO;
import timetable.classes.Route;
import timetable.entity.TrackEntity;
import timetable.service.TrackService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service("TrackService")
public class TrackServiceImpl implements TrackService {
    @Autowired
    private TrackDAO trackDAO;

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
    public String showFirstStation(long id){
        TrackEntity trackEntity = findById(id);
        return trackDAO.firstStation(trackEntity.getId());
    }

    @Override
    public String showLastStation(long id) {
        TrackEntity trackEntity = findById(id);
        return trackDAO.lastStation(trackEntity.getId());
    }

    @Override
    public String showType(long id) {

        int type = trackDAO.showType(id);
        if( type == 1) {
            return "ежедневно";
        } else if (type == 2) {
            return "по будням";
        } else if (type == 3) {
            return "по выходным";
        }
        else return "Не указано";
    }

    @Override
    public List<Route> showAllroutes() throws SQLException {
            List<Route> routeList = new ArrayList<>();
        System.out.println(trackDAO.findAll().size());
            for (TrackEntity trackEntity: trackDAO.findAll()
            ) {
                Route tempRoute = new Route();
                System.out.printf(trackDAO.firstStation(trackEntity.getId()) + "\n");
                tempRoute.setFirstStation(trackDAO.firstStation(trackEntity.getId()));
                System.out.printf(trackDAO.lastStation(trackEntity.getId())+ "\n");
                tempRoute.setLastStation(trackDAO.lastStation(trackEntity.getId()));
                tempRoute.setType(showType(trackEntity.getId()));
                tempRoute.setId(trackEntity.getId());
                routeList.add(tempRoute);
            }
            return routeList;
    }

    @Override
    public List<Route> showRouteByStation(String stationName) throws SQLException{
            List<Route> routeList = new ArrayList<>();
            List<TrackEntity> trackEntities = trackDAO.TrackByStation(stationName);
            for (TrackEntity track: trackEntities
            ) {
                Route tempRoute = new Route();
                tempRoute.setFirstStation(trackDAO.firstStation(track.getId()));
                tempRoute.setLastStation(trackDAO.lastStation(track.getId()));
                tempRoute.setType(showType(track.getId()));
                tempRoute.setId(track.getId());
                routeList.add(tempRoute);
            }
            return routeList;
    }
}
