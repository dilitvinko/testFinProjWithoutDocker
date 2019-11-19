package testfinproj.service;

import testfinproj.entities.People;
import testfinproj.entities.Task;

import java.util.List;

public interface TaskService {

    Task addTask(Task task);

    Task getOneTask(Long id);

    void delete(Task task);

    Task editTask(Task task);

    List<Task> getAll();

    List<Task> getAllTasksFromPeople(People people);
}
