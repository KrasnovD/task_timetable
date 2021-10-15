package timetable.DAOImpl;

import timetable.DAO.RouteDAO;
import timetable.DAO.StationDAO;
import timetable.classes.Station;
import timetable.entity.RouteEntity;
import timetable.entity.StationEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StationDAOImpl implements StationDAO {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<StationEntity> findAll() {
        return entityManager.createQuery("SELECT s FROM station s").getResultList();
    }
}
