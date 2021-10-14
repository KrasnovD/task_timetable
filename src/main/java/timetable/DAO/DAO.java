package timetable.DAO;

import java.util.Collection;
import java.util.List;

public interface DAO <T> {
    Collection<T> findAll();
}
