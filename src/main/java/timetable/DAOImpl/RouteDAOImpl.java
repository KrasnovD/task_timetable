package timetable.DAOImpl;

import timetable.DAO.RouteDAO;
import timetable.classes.Station;
import timetable.entity.RouteEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class RouteDAOImpl implements RouteDAO{
    private Class<Station> stationClass;
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Station> showAllStations(long id) {
        Query query =entityManager.createNativeQuery( "SELECT stations.name, routes_stations.time FROM tracks\n" +
                        "INNER JOIN routes ON tracks.routes_id = routes.id\n" +
                        "INNER JOIN routes_stations ON routes.id = routes_stations.routes_id\n" +
                        "INNER JOIN stations ON stations.id = routes_stations.stations_id\n" +
                        "WHERE tracks.id =:id\n" +
                        "ORDER BY routes_stations.sequence")
                .setParameter("id",id);
        List<Object[]> stations= query.getResultList();
        ArrayList<Station> stationList = new ArrayList<>();
        for(Object[] station : stations) {
            Station tempStation = new Station();
            tempStation.setName((String)station[0]);
            tempStation.setTime((Time) station[1]);
            stationList.add(tempStation);
        }
        return stationList;
    }

    @Override
    public List<RouteEntity> findAll() {
        return entityManager.createQuery("SELECT r FROM route r").getResultList();
    }
}
