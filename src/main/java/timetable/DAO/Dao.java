package timetable.DAO;


import org.springframework.data.repository.NoRepositoryBean;
import timetable.entity.Entity;

import java.util.List;
@NoRepositoryBean
public interface Dao<T extends Entity> {
    Long save(T entity);

    T findById(Long id);

    void update(T entity);

    void delete(Long id);

    List<T> readAll();

}
