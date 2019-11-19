package testfinproj.service;

import testfinproj.entities.LogTask;
import testfinproj.entities.Task;

import java.util.List;

public interface LogTaskService {

    LogTask addLogTask(LogTask logTask);

    LogTask getOneLogTask(Long id);

    void delete(LogTask logTask);

    LogTask editLogTask(LogTask logTask);

    List<LogTask> getAll();

    List<LogTask> getAllLogsFromTask(Task task);
}
