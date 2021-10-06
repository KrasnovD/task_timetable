package timetable.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import timetable.entity.Route;
import timetable.repository.RouteRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RouteService implements RouteRepository {
    @Autowired
    RouteRepository routeRepository;

    public List<Route> allRoutes() {
        return routeRepository.findAll();
    }
    @Override
    public List<Route> findAll() {
        return null;
    }

    @Override
    public List<Route> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Route> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Route> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Route route) {

    }

    @Override
    public void deleteAll(Iterable<? extends Route> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Route> S save(S s) {

        return null;
    }

    @Override
    public <S extends Route> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Route> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Route> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Route> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Route getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Route> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Route> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Route> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Route> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Route> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Route> boolean exists(Example<S> example) {
        return false;
    }
    @PersistenceContext
    EntityManager entityManager;



    @Override
    public List<String> showAllRoute(Long id) {
        return null;
    }

    @Override
    public String showFirstStation(Long id) {
        return null;
    }

    @Override
    public String showLastStation(Long id) {
        return null;
    }

    @Override
    public Integer showType(Long id) {
        return null;
    }

    @Override
    public List<Long> allIdRoutes() {
        return null;
    }

    @Override
    public Long trackid(Long id) {
        return null;
    }

    public String typeRoute(long id){
            int i = routeRepository.showType(id);
            if(i == 1){
                return "ежедневно";
            }
            if(i == 2){
                return "по будням";
            }
            if(i == 3){
                return "по выходным";
            }
        return null;
    }

    public class TEST {
        private String type;
        private String fStation;
        private String lStation;
        private long id;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getfStation() {
            return fStation;
        }

        public void setfStation(String fStation) {
            this.fStation = fStation;
        }

        public String getlStation() {
            return lStation;
        }

        public void setlStation(String lStation) {
            this.lStation = lStation;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }
    }
    public List<TEST> showAllRoutes(){
        ArrayList<TEST> res = new ArrayList<TEST>();
        for (Long i:routeRepository.allIdRoutes()) {
            TEST temp = new TEST();
            temp.setType(typeRoute(i));
            temp.setfStation(routeRepository.showFirstStation(i));
            temp.setlStation(routeRepository.showLastStation(i));
            temp.setId(routeRepository.trackid(i));
            res.add(temp);
        }
        return res;
    }
//    @Override
//    public String findLastStation() {
//        return null;
//    }
//    public S test(){
//        Station station = new Station();
//
//        station.setName(routeRepository.findLastStation());
//        //stations.add(objects.get(0).);
//        return station;
//    }

}
