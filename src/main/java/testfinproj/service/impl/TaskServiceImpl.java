package testfinproj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testfinproj.entities.People;
import testfinproj.entities.Task;
import testfinproj.repository.TaskRepository;
import testfinproj.service.TaskService;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public Task addTask(Task task) {
        Task savedTask = taskRepository.saveAndFlush(task);
        return savedTask;
    }

    @Override
    public Task getOneTask(Long id) {
        return taskRepository.getOne(id);
    }

    @Override
    public List<Task> getAllTasksFromPeople(People people) {
        return taskRepository.findByPeople(people);
    }

    @Override
    public void delete(Task task) {
        taskRepository.delete(task);
    }

    @Override
    public Task editTask(Task task) {
        return taskRepository.saveAndFlush(task);
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }
}
