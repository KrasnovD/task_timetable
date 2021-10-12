package timetable.DAOImpl;

import timetable.DAO.DaoException;
import timetable.DAO.TrackDAO;
import timetable.entity.RouteEntity;
import timetable.entity.StationEntity;
import timetable.entity.TrackEntity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrackDAOImpl extends DAOImpl implements TrackDAO {
    @Override
    public Long save(TrackEntity trackEntity) throws DaoException {
        String sql = "INSERT INTO tracks(type, routes_id) VALUES (?,?)";
        ResultSet resultSet = null;
        try (PreparedStatement statement = getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, trackEntity.getType());
            statement.setLong(2, trackEntity.getRoutes_id());
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            resultSet.next();
            Long id = resultSet.getLong(1);
            trackEntity.setId(id);
            return id;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            try {
                assert resultSet != null;
                resultSet.close();
            } catch (Exception ignored) {
            }
        }
    }

    @Override
    public TrackEntity findById(Long id) throws DaoException {
        String sql = "SELECT tracks.type, tracks.routes_id FROM tracks WHERE id = ?";
        ResultSet resultSet = null;
        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            TrackEntity trackEntity = null;
            if (resultSet.next()) {
                trackEntity = new TrackEntity();
                trackEntity.setId(id);
                trackEntity.setType(resultSet.getInt("type"));
                trackEntity.setRoutes_id(resultSet.getLong("routes_id"));
            }
            return trackEntity;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            try {
                assert resultSet != null;
                resultSet.close();
            } catch (Exception ignored) {
            }
        }
    }

    @Override
    public void update(TrackEntity trackEntity) throws DaoException {
        String sql = "UPDATE tracks SET type = ?, routes_id =? WHERE id = ?";
        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.setInt(1, trackEntity.getType());
            statement.setLong(2, trackEntity.getRoutes_id());
            statement.setLong(3, trackEntity.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void delete(Long id) throws DaoException {
        String sql = "DELETE FROM tracks WHERE id = ?";
        PreparedStatement statement = null;
        try {
            statement = getConnection().prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch(SQLException e) {
            throw new DaoException(e);
        } finally {
            try {
                assert statement != null;
                statement.close();
            } catch(Exception ignored) {}
        }
    }

    @Override
    public List<TrackEntity> readAll() throws DaoException {
        String sql = "SELECT id, type, routes_id FROM tracks";
        try (PreparedStatement statement = getConnection().prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {
            List<TrackEntity> trackEntities = new ArrayList<>();
            while (resultSet.next()) {
                TrackEntity trackEntity = new TrackEntity();
                trackEntity.setId(resultSet.getLong("id"));
                trackEntity.setType(resultSet.getInt("type"));
                trackEntity.setRoutes_id(resultSet.getLong("routes_id"));
                trackEntities.add(trackEntity);
            }
            return trackEntities;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public String lastStation(long id) throws DaoException, SQLException {
        String sql = "SELECT stations.name FROM tracks INNER JOIN routes ON tracks.routes_id = routes.id INNER JOIN routes_stations ON routes.id = routes_stations.routes_id INNER JOIN stations ON stations.id = routes_stations.stations_id WHERE tracks.id = ? ORDER BY routes_stations.sequence DESC LIMIT 1";
        try{
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                return resultSet.getString("name");
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return "";
    }

    @Override
    public String firstStation(long id) throws DaoException, SQLException {
        String sql = "SELECT stations.name FROM tracks INNER JOIN routes ON tracks.routes_id = routes.id INNER JOIN routes_stations ON routes.id = routes_stations.routes_id INNER JOIN stations ON stations.id = routes_stations.stations_id WHERE tracks.id = ? ORDER BY routes_stations.sequence ASC LIMIT 1";
        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                return resultSet.getString("name");
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return "";
    }
    @Override
    public String showType(long id) throws DaoException {
        String sql = "SELECT tracks.type FROM tracks INNER JOIN routes ON tracks.routes_id = routes.id WHERE tracks.id = ?";
        try{
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            int type = 0;
            while (resultSet.next()) {
                type = resultSet.getInt("type");
            }
            if (type == 1) {
                return "ежедневно";
            } else if (type == 2) {
                return "по будням";
            } else if (type == 3) {
                return "по выходным";
            }
            else return "Не указано";
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "";
    }

    @Override
    public long tickets(long id) throws DaoException {
        return 0;
    }

    @Override
    public List<TrackEntity> TrackByStation(String stationName) throws DaoException {
        String sql = "SELECT tracks.id, tracks.type, tracks.routes_id FROM tracks " +
                "INNER JOIN routes ON tracks.routes_id = routes.id " +
                "INNER JOIN routes_stations ON routes.id = routes_stations.routes_id " +
                "INNER JOIN stations ON stations.id = routes_stations.stations_id " +
                "WHERE stations.name LIKE ?";
        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setString(1,stationName);
            ResultSet resultSet = statement.executeQuery();
            List<TrackEntity> trackEntities = new ArrayList<>();
            while (resultSet.next()) {
                TrackEntity trackEntity = new TrackEntity();
                trackEntity.setId(resultSet.getLong("id"));
                trackEntity.setType(resultSet.getInt("type"));
                trackEntity.setRoutes_id(resultSet.getLong("routes_id"));
                trackEntities.add(trackEntity);
            }
            return trackEntities;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
