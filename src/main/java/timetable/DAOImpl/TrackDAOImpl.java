package timetable.DAOImpl;

import liquibase.pro.packaged.A;
import timetable.DAO.RouteDAO;
import timetable.DAO.TrackDAO;
import timetable.classes.Station;
import timetable.classes.Track;
import timetable.entity.RouteEntity;
import timetable.entity.TrackEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TrackDAOImpl implements TrackDAO {
//    @Override
//    public Long save(TrackEntity trackEntity) {
//        String sql = "INSERT INTO tracks(type, routes_id) VALUES (?,?)";
//        ResultSet resultSet = null;
//        try (PreparedStatement statement = getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
//            statement.setInt(1, trackEntity.getType());
//            statement.setLong(2, trackEntity.getRoutes_id());
//            statement.executeUpdate();
//            resultSet = statement.getGeneratedKeys();
//            resultSet.next();
//            Long id = resultSet.getLong(1);
//            trackEntity.setId(id);
//            return id;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    @Override
//    public TrackEntity findById(Long id){
//        String sql = "SELECT tracks.type, tracks.routes_id FROM tracks WHERE id = ?";
//        ResultSet resultSet = null;
//        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
//            statement.setLong(1, id);
//            resultSet = statement.executeQuery();
//            TrackEntity trackEntity = null;
//            if (resultSet.next()) {
//                trackEntity = new TrackEntity();
//                trackEntity.setId(id);
//                trackEntity.setType(resultSet.getInt("type"));
//                trackEntity.setRoutes_id(resultSet.getLong("routes_id"));
//            }
//            return trackEntity;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return new TrackEntity();
//        }
//    }
//
//    @Override
//    public void update(TrackEntity trackEntity){
//        String sql = "UPDATE tracks SET type = ?, routes_id =? WHERE id = ?";
//        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
//            statement.setInt(1, trackEntity.getType());
//            statement.setLong(2, trackEntity.getRoutes_id());
//            statement.setLong(3, trackEntity.getId());
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void delete(Long id){
//        String sql = "DELETE FROM tracks WHERE id = ?";
//        PreparedStatement statement = null;
//        try {
//            statement = getConnection().prepareStatement(sql);
//            statement.setLong(1, id);
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public List<TrackEntity> readAll() {
//        String sql = "SELECT id, type, routes_id FROM tracks";
//        try (PreparedStatement statement = getConnection().prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {
//            List<TrackEntity> trackEntities = new ArrayList<>();
//            while (resultSet.next()) {
//                TrackEntity trackEntity = new TrackEntity();
//                trackEntity.setId(resultSet.getLong("id"));
//                trackEntity.setType(resultSet.getInt("type"));
//                trackEntity.setRoutes_id(resultSet.getLong("routes_id"));
//                trackEntities.add(trackEntity);
//            }
//            return trackEntities;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return new ArrayList<>();
//        }
//    }
//
//    @Override
//    public String lastStation(long id){
//        String sql = "SELECT stations.name FROM tracks INNER JOIN routes ON tracks.routes_id = routes.id INNER JOIN routes_stations ON routes.id = routes_stations.routes_id INNER JOIN stations ON stations.id = routes_stations.stations_id WHERE tracks.id = ? ORDER BY routes_stations.sequence DESC LIMIT 1";
//        try{
//            PreparedStatement statement = getConnection().prepareStatement(sql);
//            statement.setLong(1, id);
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                return resultSet.getString("name");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return "";
//    }
//
//    @Override
//    public String firstStation(long id){
//        String sql = "SELECT stations.name FROM tracks " +
//                "INNER JOIN routes ON tracks.routes_id = routes.id " +
//                "INNER JOIN routes_stations ON routes.id = routes_stations.routes_id " +
//                "INNER JOIN stations ON stations.id = routes_stations.stations_id " +
//                "WHERE tracks.id = ? ORDER BY routes_stations.sequence ASC LIMIT 1";
//        try {
//            PreparedStatement statement = getConnection().prepareStatement(sql);
//            statement.setLong(1, id);
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                return resultSet.getString("name");
//            }
//            return "";
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return "";
//        }
//    }
//    @Override
//    public String showType(long id){
//        String sql = "SELECT tracks.type FROM tracks INNER JOIN routes ON tracks.routes_id = routes.id WHERE tracks.id = ?";
//        try{
//            PreparedStatement statement = getConnection().prepareStatement(sql);
//            statement.setLong(1, id);
//            ResultSet resultSet = statement.executeQuery();
//            int type = 0;
//            while (resultSet.next()) {
//                type = resultSet.getInt("type");
//            }
//            if (type == 1) {
//                return "ежедневно";
//            } else if (type == 2) {
//                return "по будням";
//            } else if (type == 3) {
//                return "по выходным";
//            }
//            else return "Не указано";
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return "";
//    }
//
//    @Override
//    public long tickets(long id){
//        return 0;
//    }
//
//    @Override
//    public List<TrackEntity> TrackByStation(String stationName){
//        String sql = "SELECT tracks.id, tracks.type, tracks.routes_id FROM tracks " +
//                "INNER JOIN routes ON tracks.routes_id = routes.id " +
//                "INNER JOIN routes_stations ON routes.id = routes_stations.routes_id " +
//                "INNER JOIN stations ON stations.id = routes_stations.stations_id " +
//                "WHERE stations.name LIKE ?";
//        try {
//            PreparedStatement statement = getConnection().prepareStatement(sql);
//            statement.setString(1,stationName);
//            ResultSet resultSet = statement.executeQuery();
//            List<TrackEntity> trackEntities = new ArrayList<>();
//            while (resultSet.next()) {
//                TrackEntity trackEntity = new TrackEntity();
//                trackEntity.setId(resultSet.getLong("id"));
//                trackEntity.setType(resultSet.getInt("type"));
//                trackEntity.setRoutes_id(resultSet.getLong("routes_id"));
//                trackEntities.add(trackEntity);
//            }
//            return trackEntities;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return  new ArrayList<>();
//        }
//    }
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
    public String firstStation(long id) throws SQLException {
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
        return null;
    }


    @Override
    public Collection<TrackEntity> findAll() {
        return null;
    }

    @Override
    public List<Long> findAllId() {
        Query query = entityManager.createNativeQuery("SELECT tracks.id FROM tracks ");
        ArrayList<Long> id = new ArrayList<>();
        List<Object[]> res = query.getResultList();
        for (Object[] temp:res
             ) {
            id.add((Long)temp[0]);
        }
        return id;
    }
}
