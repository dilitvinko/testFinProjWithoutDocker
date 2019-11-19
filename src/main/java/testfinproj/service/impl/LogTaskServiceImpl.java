package testfinproj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testfinproj.entities.LogTask;
import testfinproj.entities.Task;
import testfinproj.repository.LogTaskRepository;
import testfinproj.service.LogTaskService;

import java.util.List;

@Service
public class LogTaskServiceImpl implements LogTaskService {

    @Autowired
    private LogTaskRepository logTaskRepository;

    @Override
    public LogTask addLogTask(LogTask logTask) {
        LogTask savedLogTask = logTaskRepository.saveAndFlush(logTask);
        return savedLogTask;
    }

    @Override
    public LogTask getOneLogTask(Long id) {
        return logTaskRepository.getOne(id);
    }

    @Override
    public void delete(LogTask logTask) {
        logTaskRepository.delete(logTask);
    }

    @Override
    public LogTask editLogTask(LogTask logTask) {
        return logTaskRepository.saveAndFlush(logTask);
    }

    @Override
    public List<LogTask> getAll() {
        return logTaskRepository.findAll();
    }

    @Override
    public List<LogTask> getAllLogsFromTask(Task task) {
        return logTaskRepository.findByTask(task);
    }
}
