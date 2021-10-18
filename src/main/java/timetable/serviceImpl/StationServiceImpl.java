package timetable.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import timetable.DAO.StationDAO;
import timetable.DAO.TrackDAO;
import timetable.entity.StationEntity;
import timetable.service.StationService;

import java.util.ArrayList;
import java.util.List;

@Service("StationService")
public class StationServiceImpl implements StationService {
    @Autowired
    private StationDAO stationDAO;


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
