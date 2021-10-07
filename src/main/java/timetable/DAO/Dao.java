package timetable.DAO;


import timetable.entity.Entity;

public interface Dao<T extends Entity> {
    Long save(T entity) throws DaoException;

    T findById(Long id) throws DaoException;

    void update(T entity) throws DaoException;

    void delete(Long id) throws DaoException;
}
