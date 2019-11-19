package testfinproj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import testfinproj.entities.LogTask;
import testfinproj.entities.Task;

import java.util.List;

@Repository
public interface LogTaskRepository extends JpaRepository<LogTask, Long> {
    List<LogTask> findByTask(Task task);
}
