package timetable.DAOImpl;

import timetable.DAO.TrackDAO;
import timetable.entity.TrackEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;

public class TrackDAOImpl implements TrackDAO {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public String lastStation(long id) {
        Query query =entityManager.createNativeQuery( "SELECT stations.name " +
                        "FROM tracks " +
                        "INNER JOIN routes ON tracks.routes_id = routes.id " +
                        "INNER JOIN routes_stations ON routes.id = routes_stations.routes_id " +
                        "INNER JOIN stations ON stations.id = routes_stations.stations_id " +
                        "WHERE tracks.id = :id ORDER BY routes_stations.sequence DESC LIMIT 1")
                .setParameter("id",id);
        return (String)query.getSingleResult();
    }

    @Override
    public String firstStation(long id){
        Query query =entityManager.createNativeQuery( "SELECT stations.name " +
                        "FROM tracks " +
                        "INNER JOIN routes ON tracks.routes_id = routes.id " +
                        "INNER JOIN routes_stations ON routes.id = routes_stations.routes_id " +
                        "INNER JOIN stations ON stations.id = routes_stations.stations_id " +
                        "WHERE tracks.id = :id ORDER BY routes_stations.sequence ASC LIMIT 1")
                .setParameter("id",id);
        return (String)query.getSingleResult();
    }

    @Override
    public String showType(long id) {
        Query query =entityManager.createNativeQuery( "SELECT tracks.type " +
                        "FROM tracks " +
                        "INNER JOIN routes ON tracks.routes_id = routes.id " +
                        "WHERE tracks.id = :id")
                .setParameter("id",id);
        int type = (Integer)query.getSingleResult();
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
    public List<TrackEntity> TrackByStation(String stationName) {
        return entityManager.createQuery("SELECT t FROM track t INNER JOIN t.route.station s WHERE s.name = :name")
                .setParameter("name",stationName)
                .getResultList();
    }


    @Override
    public List<TrackEntity> findAll() {
        return entityManager.createQuery("SELECT t FROM track t").getResultList();
    }
}
