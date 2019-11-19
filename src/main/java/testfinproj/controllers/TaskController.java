package testfinproj.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import testfinproj.entities.People;
import testfinproj.entities.Task;
import testfinproj.repository.PeopleRepository;
import testfinproj.service.impl.PeopleServiceImpl;
import testfinproj.service.impl.TaskServiceImpl;

import java.util.List;

@Controller
public class TaskController {
    private final PeopleServiceImpl peopleService;
    private final TaskServiceImpl taskService;
    private final PeopleRepository peopleRepository;


    public TaskController(PeopleServiceImpl peopleService, TaskServiceImpl taskService, PeopleRepository peopleRepository) {
        this.peopleService = peopleService;
        this.taskService = taskService;
        this.peopleRepository = peopleRepository;
    }

    @GetMapping("/tasks/{id}")
    public ModelAndView allTasksOfOnePeople(ModelAndView modelAndView, @PathVariable("id") long id) {
        People people = peopleRepository.findFirstById(id);
        List<Task> taskList = taskService.getAllTasksFromPeople(people);
        modelAndView.addObject("taskList", taskList);
        modelAndView.addObject("people", people);
        modelAndView.setViewName("tasks");
        return modelAndView;
    }

    @GetMapping("/tasks/{idPeople}/addTask")
    public ModelAndView addTask(ModelAndView modelAndView, @PathVariable("idPeople") long id) {
        People people = peopleService.getOnePeople(id);
        modelAndView.addObject("people", people);
        modelAndView.setViewName("editTask");
        return modelAndView;
    }

    @PostMapping("/tasks/{idPeople}/addTask")
    public ModelAndView addTask(ModelAndView modelAndView, @PathVariable("idPeople") long idPeople, @ModelAttribute("task") Task task) {
        People people = peopleService.getOnePeople(idPeople);
        task.setPeople(people);
        taskService.addTask(task);
        modelAndView.setViewName("redirect:/tasks/" + idPeople);
        return modelAndView;
    }

    @GetMapping("/tasks/{idPeople}/edit/{idTask}")
    public ModelAndView editTask(ModelAndView modelAndView, @PathVariable("idPeople") long idPeople,
                                 @PathVariable("idTask") long idTask) {
        People people = peopleService.getOnePeople(idPeople);
        Task task = taskService.getOneTask(idTask);
        modelAndView.addObject("people", people);
        modelAndView.addObject("task", task);
        modelAndView.setViewName("editTask");
        return modelAndView;
    }

    @PostMapping("/tasks/{idPeople}/edit/{idTask}")
    public ModelAndView editTask(ModelAndView modelAndView, @PathVariable long idPeople, @PathVariable long idTask,
                                 @ModelAttribute("task") Task task) {
        Task editTask = taskService.getOneTask(idTask);
        editTask.setNameTask(task.getNameTask());
        editTask.setState(task.isState());
        taskService.editTask(editTask);
        modelAndView.setViewName("redirect:/tasks/" + idPeople);
        return modelAndView;
    }

}
