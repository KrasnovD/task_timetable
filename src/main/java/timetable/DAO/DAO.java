package timetable.DAO;

import java.util.Collection;
import java.util.List;

public interface DAO <T> {
    List<T> findAll();
}
