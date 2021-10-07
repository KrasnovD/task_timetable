package timetable.service;

import org.hibernate.service.spi.ServiceException;
import timetable.DAO.DaoException;
import timetable.DAO.StationDAO;
import timetable.entity.StationEntity;

import java.util.List;

public class StationServiceImpl implements StationService{
    private StationDAO stationDAO;

    @Override
    public List<StationEntity> findAll() throws ServiceException {
        try {
            return stationDAO.readAll();
        } catch(DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public StationEntity findById(Long id) throws ServiceException {
        try {
            return stationDAO.findById(id);
        } catch(DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void save(StationEntity stationEntity) throws ServiceException {
        try {
            if(stationEntity.getId() != null) {
                stationDAO.update(stationEntity);
            } else {
                stationDAO.save(stationEntity);
            }
        } catch(DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void delete(Long id) throws ServiceException {
        try {
            stationDAO.delete(id);
        } catch(DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
