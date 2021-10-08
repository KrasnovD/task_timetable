package timetable.serviceImpl;

import timetable.DAO.DaoException;
import timetable.DAOImpl.TrackDAOImpl;
import timetable.entity.TrackEntity;
import timetable.service.ServiceException;
import timetable.service.TrackService;

import java.util.List;

public class TrackServiceImpl implements TrackService {

    TrackDAOImpl trackDAO;
    public TrackServiceImpl(TrackDAOImpl trackDAOImpl) {
        this.trackDAO = trackDAOImpl;
    }

    @Override
    public List<TrackEntity> findAll() throws ServiceException {
        try {
            return trackDAO.readAll();
        } catch(DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public TrackEntity findById(Long id) throws ServiceException {
        try {
            return trackDAO.findById(id);
        } catch(DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void save(TrackEntity entity) throws ServiceException {
        try {
            if(entity.getId() != null) {
                trackDAO.update(entity);
            } else {
                trackDAO.save(entity);
            }
        } catch(DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void delete(Long id) throws ServiceException {
        try {
            trackDAO.delete(id);
        } catch(DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
