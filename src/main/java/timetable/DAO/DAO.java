package timetable.DAO;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Indexed;
import timetable.entity.TrackEntity;

@NoRepositoryBean
public interface DAO<T, ID> extends Repository<T, Long> {
}
