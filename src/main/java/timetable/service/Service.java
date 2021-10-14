package timetable.service;


import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface Service<T extends Serializable> {
    Collection<T> findAll();

    T findById(Long id);

    void save(T entity);

    void delete(Long id);
}
