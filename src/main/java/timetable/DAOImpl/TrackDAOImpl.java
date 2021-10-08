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
}
