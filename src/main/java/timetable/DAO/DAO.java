package timetable.DAO;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;


@NoRepositoryBean
public interface DAO<T, ID> extends Repository<T, Long> {
}
