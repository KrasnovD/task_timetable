package timetable.serviceImpl;

import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;
import timetable.DAO.DaoException;
import timetable.DAO.StationDAO;
import timetable.DAOImpl.StationDAOImpl;
import timetable.entity.StationEntity;
import timetable.service.StationService;

import java.util.List;
@Service("StationServiceImpl")
public class StationServiceImpl implements StationService {
    private StationDAOImpl stationDAO;

    public StationServiceImpl(StationDAOImpl stationDAOImpl) {
        this.stationDAO=stationDAOImpl;
    }

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
