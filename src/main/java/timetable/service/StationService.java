package timetable.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import timetable.entity.Station;
import timetable.repository.StationRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;


@Service
public class StationService implements StationRepository {
    @Autowired
    StationRepository stationRepository;

    @Override
    public List<Station> findAll() {
        List<Station> stationFromDB = (stationRepository.findAll());
        return stationFromDB;
    }

    @Override
    public List<Station> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Station> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Station> findAllById(Iterable<Long> iterable) {
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
    public void delete(Station station) {

    }

    @Override
    public void deleteAll(Iterable<? extends Station> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Station> S save(S s) {
        return null;
    }

    @Override
    public <S extends Station> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Station> findById(Long aLong) {
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
    public <S extends Station> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Station> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Station getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Station> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Station> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Station> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Station> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Station> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Station> boolean exists(Example<S> example) {
        return false;
    }
}
