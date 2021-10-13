package timetable.serviceImpl;

import org.springframework.stereotype.Service;
import timetable.DAOImpl.StationDAOImpl;
import timetable.entity.StationEntity;
import timetable.service.StationService;
import java.util.ArrayList;
import java.util.List;

@Service("StationService")
public class StationServiceImpl implements StationService {
    private StationDAOImpl stationDAO;

    public StationServiceImpl(StationDAOImpl stationDAOImpl) {
        this.stationDAO=stationDAOImpl;
    }

    @Override
    public List<StationEntity> findAll(){
        try {
            return stationDAO.readAll();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public StationEntity findById(Long id){
        try {
            return stationDAO.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new StationEntity();
        }
    }

    @Override
    public void save(StationEntity stationEntity){
        try {
            if(stationEntity.getId() != null) {
                stationDAO.update(stationEntity);
            } else {
                stationDAO.save(stationEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id){
        try {
            stationDAO.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
