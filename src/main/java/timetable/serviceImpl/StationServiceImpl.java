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
            return stationDAO.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public StationEntity findById(Long id){
        return null;
    }

    @Override
    public void save(StationEntity stationEntity){

    }

    @Override
    public void delete(Long id){

    }
}
